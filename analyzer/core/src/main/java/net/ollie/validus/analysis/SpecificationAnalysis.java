package net.ollie.validus.analysis;

import net.ollie.validus.analysis.verification.TestVerification;

import java.util.Set;

public interface SpecificationAnalysis {

    default boolean isVerified() {
        return !this.testVerifications().isEmpty();
    }

    Set<TestVerification> testVerifications();

}
