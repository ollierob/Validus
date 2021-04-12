package net.ollie.validus.server.authentication.session;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.Optional;

public interface UserSessionProvider {

    @Nonnull
    Optional<UserSession> getSession(String sessionId);

    UserSessionProvider STUB = s -> Optional.empty();

}
