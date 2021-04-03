package net.ollie.validus.project.java;

import net.ollie.validus.project.LocalProject;

import javax.annotation.Nonnull;
import java.net.URL;
import java.nio.file.Path;

public record LocalJavaProject(Path root, RemoteJavaProject remote) implements JavaProject, LocalProject {

    @Nonnull
    @Override
    public URL resolveUrl(final JavaMethod method) {
        return remote.resolveUrl(method);
    }

}
