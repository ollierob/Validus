package net.ollie.validus.analysis;

import net.ollie.validus.analysis.satisfaction.Satisfaction;
import net.ollie.validus.analysis.verification.Verification;
import net.ollie.validus.specification.Specification;

import javax.annotation.Nonnull;
import java.util.Set;

public interface SpecificationAnalysis {

    @Nonnull
    Specification specification();

    default boolean isSatisfied() {
        return !this.satisfactions().isEmpty();
    }

    @Nonnull
    Set<Satisfaction> satisfactions();

    default boolean isVerified() {
        return !this.verifications().isEmpty();
    }

    @Nonnull
    Set<? extends Verification> verifications();

}
