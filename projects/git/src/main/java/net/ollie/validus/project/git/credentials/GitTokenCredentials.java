package net.ollie.validus.project.git.credentials;

public final record GitTokenCredentials(String username, String token) implements GitCredentials {

}
