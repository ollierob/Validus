package net.ollie.validus.project.java;

import net.ollie.validus.project.FromRemoteProject;
import net.ollie.validus.project.LocalProject;
import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.RemoteProject;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;

public record RemoteJavaProject(ProjectId id, RemoteProject remote, Path javaPath, int version) implements JavaProject, FromRemoteProject<LocalJavaProject> {

    public RemoteJavaProject(final ProjectId id, final RemoteProject remote, final int version) {
        this(id, remote, null, version);
    }

    @Override
    public URL resolveUrl(final JavaMethod method) {
        return remote.resolveUrl(method.relativeFilePath());
    }

    @Nonnull
    @Override
    public LocalJavaProject transform(final LocalProject project) {
        final var javaPath = this.javaPath == null
                ? project.root()
                : new File(project.root(), this.javaPath.toString());
        return new LocalJavaProject(javaPath, this);
    }

}
