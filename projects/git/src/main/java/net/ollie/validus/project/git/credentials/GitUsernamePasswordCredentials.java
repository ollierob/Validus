package net.ollie.validus.project.git.credentials;

public final record GitUsernamePasswordCredentials(String username, String password) implements GitCredentials {

}
