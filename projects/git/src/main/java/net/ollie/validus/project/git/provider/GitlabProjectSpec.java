package net.ollie.validus.project.git.provider;

import net.ollie.validus.project.git.credentials.GitCredentials;

import java.net.URL;

public class GitlabProjectSpec extends GitProjectSpec {

    public GitlabProjectSpec(final URL url, final String branch, final GitCredentials credentials) {
        super(url, branch, credentials);
    }

}
