package net.ollie.validus.specification;

import com.google.common.base.MoreObjects;
import net.ollie.protobuf.BuildsProto;
import net.ollie.validus.SpecificationProto;

import javax.annotation.Nonnull;

public record Specification(SpecificationId id, String description) implements BuildsProto<SpecificationProto.Specification> {

    @Nonnull
    @Override
    public SpecificationProto.Specification toProto() {
        return this.toProtoBuilder().build();
    }

    @Nonnull
    public SpecificationProto.Specification.Builder toProtoBuilder() {
        return SpecificationProto.Specification.newBuilder()
                .setId(id.value())
                .setDescription(MoreObjects.firstNonNull(description, ""));
    }

}
