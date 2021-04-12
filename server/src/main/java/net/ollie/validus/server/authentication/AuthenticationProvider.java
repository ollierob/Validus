package net.ollie.validus.server.authentication;

import net.ollie.validus.server.authentication.context.AuthenticationContext;

import javax.annotation.Nonnull;

public interface AuthenticationProvider<F> {

    @Nonnull
    AuthenticationContext provide(F data);

}
