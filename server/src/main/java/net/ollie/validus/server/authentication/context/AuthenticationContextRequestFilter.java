package net.ollie.validus.server.authentication.context;

import net.ollie.validus.server.authentication.session.UserSessionProvider;
import org.jboss.resteasy.core.ResteasyContext;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
@Singleton
public class AuthenticationContextRequestFilter implements ContainerRequestFilter {

    private final UserSessionProvider sessionProvider;

    @Inject
    AuthenticationContextRequestFilter(final UserSessionProvider sessionProvider) {
        this.sessionProvider = sessionProvider;
    }

    @Override
    public void filter(final ContainerRequestContext requestContext) {
        ResteasyContext.pushContext(AuthenticationContext.class, this.getContext(requestContext));
    }

    @Nonnull
    private AuthenticationContext getContext(final ContainerRequestContext context) {
        final var headers = context.getHeaders();
        final var sessionId = headers.get("SessionId");
        if (sessionId == null || sessionId.size() != 1) return AuthenticationContext.NOT_AUTHORIZED;
        return sessionProvider.getSession(sessionId.get(0))
                .<AuthenticationContext>map(AuthenticatedContext::new)
                .orElse(AuthenticationContext.NOT_AUTHORIZED);
    }

}
