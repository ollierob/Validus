package net.ollie.validus.server.authentication.context;

import net.ollie.validus.server.authentication.session.UserSession;

public interface AuthenticationContext {

    UserSession session();

    AuthenticationContext NOT_LOGGED_IN = new AuthenticationContext() {

        @Override
        public UserSession session() {
            throw new UnsupportedOperationException();
        }

    };

}
