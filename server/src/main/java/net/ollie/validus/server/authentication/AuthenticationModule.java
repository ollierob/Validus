package net.ollie.validus.server.authentication;

import com.google.inject.AbstractModule;
import net.ollie.validus.server.authentication.context.AuthenticationContextRequestFilter;
import net.ollie.validus.server.authentication.session.UserSessionProvider;

public class AuthenticationModule extends AbstractModule {

    @Override
    protected void configure() {
        super.configure();
        this.bind(AuthenticationContextRequestFilter.class);
        this.bind(UserSessionProvider.class).toInstance(UserSessionProvider.STUB);
    }

}
