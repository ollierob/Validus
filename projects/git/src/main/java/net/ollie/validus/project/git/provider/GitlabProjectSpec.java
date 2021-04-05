package net.ollie.validus.project.git.provider;

import net.ollie.validus.project.ProjectId;

import java.net.URL;

public class GitlabProjectSpec extends GitProjectSpec {

    public GitlabProjectSpec(final ProjectId id, final int version, final URL url) {
        super(id, version, url);
    }

}
