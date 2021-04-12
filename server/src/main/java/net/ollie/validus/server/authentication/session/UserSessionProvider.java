package net.ollie.validus.server.authentication.session;

import javax.annotation.Nonnull;
import java.util.Optional;

public interface UserSessionProvider {

    @Nonnull
    UserSession openSession(String username, String password) throws LoginFailedException;

    @Nonnull
    Optional<UserSession> getSession(String sessionId);

    UserSessionProvider STUB = new UserSessionProvider() {

        @Nonnull
        @Override
        public UserSession openSession(final String username, final String password) throws LoginFailedException {
            throw new LoginFailedException();
        }

        @Nonnull
        @Override
        public Optional<UserSession> getSession(final String sessionId) {
            return Optional.empty();
        }

    };

}
