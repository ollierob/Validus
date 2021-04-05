package net.ollie.validus.project.git.provider;

import net.ollie.validus.project.ProjectId;

import java.net.URL;

public class GitProjectSpec {

    private final ProjectId id;
    private final int version;
    private final URL url;

    public GitProjectSpec(final ProjectId id, final int version, final URL url) {
        this.id = id;
        this.version = version;
        this.url = url;
    }

    public ProjectId id() {
        return id;
    }

}
