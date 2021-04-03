package net.ollie.validus.project.java;

import net.ollie.validus.project.LocalProject;
import net.ollie.validus.project.ProjectId;

import javax.annotation.Nonnull;
import java.net.URL;
import java.nio.file.Path;

public record LocalJavaProject(ProjectId id, Path root, RemoteJavaProject source) implements JavaProject, LocalProject {

    @Nonnull
    @Override
    public URL resolveUrl(final JavaMethod method) {
        return source.resolveUrl(method);
    }

}
