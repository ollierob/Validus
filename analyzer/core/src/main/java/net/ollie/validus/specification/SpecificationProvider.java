package net.ollie.validus.specification;

import javax.annotation.Nonnull;

public interface SpecificationProvider {

    @Nonnull
    Specification require(SpecificationId id);

    SpecificationProvider STUB = id -> new Specification(id, null);

}
