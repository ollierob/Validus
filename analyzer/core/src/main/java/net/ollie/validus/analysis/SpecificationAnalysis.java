package net.ollie.validus.analysis;

import com.google.common.collect.Iterables;
import net.ollie.protobuf.BuildsProto;
import net.ollie.validus.AnalysisProto;
import net.ollie.validus.analysis.satisfaction.Satisfaction;
import net.ollie.validus.analysis.verification.Verification;
import net.ollie.validus.specification.Specification;

import javax.annotation.Nonnull;
import java.util.Set;

public non-sealed interface SpecificationAnalysis extends Analysis, BuildsProto<AnalysisProto.SpecificationAnalysis> {

    @Nonnull
    Specification specification();

    default boolean isSatisfied() {
        return !this.satisfactions().isEmpty();
    }

    @Nonnull
    Set<? extends Satisfaction> satisfactions();

    default boolean isVerified() {
        return !this.verifications().isEmpty();
    }

    @Nonnull
    Set<? extends Verification> verifications();

    @Nonnull
    @Override
    default AnalysisProto.SpecificationAnalysis toProto() {
        return this.toProtoBuilder().build();
    }

    @Nonnull
    default AnalysisProto.SpecificationAnalysis.Builder toProtoBuilder() {
        return AnalysisProto.SpecificationAnalysis.newBuilder()
                .setSpecification(this.specification().toProto())
                .addAllSatisfaction(Iterables.transform(this.satisfactions(), Satisfaction::toProto))
                .addAllVerification(Iterables.transform(this.verifications(), Verification::toProto));
    }

}
