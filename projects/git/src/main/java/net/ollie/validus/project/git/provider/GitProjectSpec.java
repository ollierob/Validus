package net.ollie.validus.project.git.provider;

import java.net.URL;

public class GitProjectSpec {

    private final int version;
    private final URL url;

    public GitProjectSpec(final int version, final URL url) {
        this.version = version;
        this.url = url;
    }

}
