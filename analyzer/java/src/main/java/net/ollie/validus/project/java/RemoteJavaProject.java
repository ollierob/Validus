package net.ollie.validus.project.java;

import net.ollie.validus.project.FromRemoteProject;
import net.ollie.validus.project.LocalProject;
import net.ollie.validus.project.RemoteProject;

import javax.annotation.Nonnull;
import java.net.URL;
import java.nio.file.Path;

public record RemoteJavaProject(RemoteProject remote, Path javaPath) implements JavaProject, FromRemoteProject<LocalJavaProject> {

    public RemoteJavaProject(final RemoteProject remote) {
        this(remote, null);
    }

    @Nonnull
    @Override
    public URL resolveUrl(final JavaMethod method) {
        throw new UnsupportedOperationException(); //TODO
    }

    @Nonnull
    @Override
    public LocalJavaProject transform(final LocalProject project) {
        final var javaPath = this.javaPath == null ? project.root() : project.root().resolve(this.javaPath);
        return new LocalJavaProject(javaPath, this);
    }

}
