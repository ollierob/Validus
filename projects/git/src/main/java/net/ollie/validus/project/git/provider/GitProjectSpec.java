package net.ollie.validus.project.git.provider;

import net.ollie.validus.project.git.credentials.GitCredentials;

import java.net.URL;

public class GitProjectSpec {

    private final URL url;
    private final String branch;
    private final GitCredentials credentials;

    public GitProjectSpec(final URL url, final String branch, final GitCredentials credentials) {
        this.url = url;
        this.branch = branch;
        this.credentials = credentials;
    }

    public URL url() {
        return url;
    }

    public String branch() {
        return branch;
    }

    public GitCredentials credentials() {
        return credentials;
    }

}
