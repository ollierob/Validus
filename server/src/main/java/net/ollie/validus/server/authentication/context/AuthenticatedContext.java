package net.ollie.validus.server.authentication.context;

import net.ollie.validus.server.authentication.session.UserSession;

record AuthenticatedContext(UserSession session) implements AuthenticationContext {

}
