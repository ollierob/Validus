package net.ollie.validus.project.git.credentials;

public sealed interface GitCredentials permits GitUsernamePasswordCredentials, GitTokenCredentials {

}
