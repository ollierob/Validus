package net.ollie.validus.project.java.git;

import net.ollie.validus.project.LocalProject;
import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.git.GitProject;
import net.ollie.validus.project.java.JavaMethod;
import net.ollie.validus.project.java.LocalJavaProject;
import net.ollie.validus.project.java.RemoteJavaProject;

import javax.annotation.Nonnull;
import java.net.URL;

public record JavaGitProject(ProjectId id, GitProject source) implements RemoteJavaProject, GitProject {

    @Nonnull
    @Override
    public URL resolveUrl(final JavaMethod method) {
        throw new UnsupportedOperationException(); //TODO
    }

    @Override
    public LocalJavaProject transform(final LocalProject project) {
        throw new UnsupportedOperationException(); //TODO
    }

}
