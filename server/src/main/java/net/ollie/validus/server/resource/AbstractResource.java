package net.ollie.validus.server.resource;

import javax.annotation.Nonnull;
import javax.ws.rs.NotFoundException;
import java.io.InputStream;

public abstract class AbstractResource {

    @Nonnull
    protected InputStream readUnprotected(final String resourcePath) {
        final var resource = this.getClass().getResourceAsStream(resourcePath);
        if(resource == null) throw new NotFoundException();
        return resource;
    }

}
