package net.ollie.validus.analysis;

import net.ollie.validus.analysis.satisfaction.Satisfaction;
import net.ollie.validus.analysis.verification.Verification;
import net.ollie.validus.specification.SpecificationId;

import javax.annotation.Nonnull;
import java.util.Set;

public non-sealed interface SpecificationAnalysis extends Analysis {

    @Nonnull
    SpecificationId specificationId();

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

}
