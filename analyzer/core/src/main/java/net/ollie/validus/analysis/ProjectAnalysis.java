package net.ollie.validus.analysis;

import com.google.common.collect.Iterables;
import net.ollie.protobuf.BuildsProto;
import net.ollie.validus.AnalysisProto;
import net.ollie.validus.project.Project;
import net.ollie.validus.specification.SpecificationId;

import javax.annotation.Nonnull;
import java.util.Map;

public non-sealed interface ProjectAnalysis extends Analysis, BuildsProto<AnalysisProto.ProjectAnalysis> {

    @Nonnull
    Project project();

    @Nonnull
    Map<SpecificationId, SpecificationAnalysis> specifications();

    default boolean hasSpecifications() {
        return !this.specifications().isEmpty();
    }

    @Nonnull
    @Override
    default AnalysisProto.ProjectAnalysis toProto() {
        return this.toProtoBuilder().build();
    }

    @Nonnull
    default AnalysisProto.ProjectAnalysis.Builder toProtoBuilder() {
        return AnalysisProto.ProjectAnalysis.newBuilder()
                .setProject(this.project().toProto())
                .addAllSpecification(Iterables.transform(this.specifications().values(), SpecificationAnalysis::toProto));
    }

}
