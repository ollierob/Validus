package net.ollie.validus.analysis.satisfaction;

import net.ollie.protobuf.BuildsProto;
import net.ollie.validus.AnalysisProto;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.net.URL;

public sealed interface Satisfaction extends BuildsProto<AnalysisProto.Satisfaction> permits ClassMethodSatisfaction {

    @CheckForNull
    URL link();

    @Nonnull
    @Override
    default AnalysisProto.Satisfaction toProto() {
        return this.toProtoBuilder().build();
    }

    @Nonnull
    default AnalysisProto.Satisfaction.Builder toProtoBuilder() {
        return AnalysisProto.Satisfaction.newBuilder();
    }

}
