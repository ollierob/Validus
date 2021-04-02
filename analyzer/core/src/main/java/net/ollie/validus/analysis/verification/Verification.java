package net.ollie.validus.analysis.verification;

import net.ollie.protobuf.BuildsProto;
import net.ollie.validus.AnalysisProto;

import javax.annotation.Nonnull;
import java.net.URL;

public sealed interface Verification extends BuildsProto<AnalysisProto.Verification> permits TestVerification {

    @Nonnull
    URL link();

    @Nonnull
    @Override
    default AnalysisProto.Verification toProto() {
        return this.toProtoBuilder().build();
    }

    @Nonnull
    default AnalysisProto.Verification.Builder toProtoBuilder() {
        return AnalysisProto.Verification.newBuilder();
    }

}
