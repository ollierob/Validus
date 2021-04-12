package net.ollie.validus.server.authentication.context;

import net.ollie.validus.server.authentication.session.UserSession;

import javax.annotation.Nonnull;
import javax.ws.rs.NotAuthorizedException;

public interface AuthenticationContext {

    @Nonnull
    UserSession session();

    AuthenticationContext NOT_AUTHORIZED = () -> {
        throw new NotAuthorizedException("Not authorized");
    };

}
