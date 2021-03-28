package net.ollie.validus.analysis;

import net.ollie.validus.analysis.satisfaction.Satisfaction;
import net.ollie.validus.analysis.verification.Verification;
import net.ollie.validus.specification.SpecificationId;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public record GenericSpecificationAnalysis(SpecificationId specificationId, Set<? extends Satisfaction> satisfactions, Set<? extends Verification> verifications) implements SpecificationAnalysis {

    public GenericSpecificationAnalysis(final SpecificationId id, final Satisfaction satisfaction) {
        this(id, Collections.singleton(satisfaction), Collections.emptySet());
    }

    public GenericSpecificationAnalysis(final SpecificationId id, final Verification verification) {
        this(id, Collections.emptySet(), Collections.singleton(verification));
    }

    @Nonnull
    @CheckReturnValue
    public SpecificationAnalysis and(final SpecificationAnalysis that) {
        if (that == null) return this;
        final var newSatisfactions = new HashSet<Satisfaction>(this.satisfactions);
        newSatisfactions.addAll(that.satisfactions());
        final var newVerifications = new HashSet<Verification>(this.verifications);
        newVerifications.addAll(that.verifications());
        return new GenericSpecificationAnalysis(specificationId, newSatisfactions, newVerifications);
    }

}
