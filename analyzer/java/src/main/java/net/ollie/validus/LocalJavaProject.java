package net.ollie.validus;

import net.ollie.validus.project.LocalProject;
import net.ollie.validus.project.ProjectId;

import javax.annotation.Nonnull;
import java.net.URL;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public record LocalJavaProject(ProjectId id, Path root, JavaProject source) implements JavaProject, LocalProject {

    @Nonnull
    @Override
    public URL resolveUrl(final JavaMethod method) {
        return source.resolveUrl(method);
    }

    @Nonnull
    @Override
    @Deprecated
    public CompletableFuture<LocalJavaProject> toLocalProject() {
        return CompletableFuture.completedFuture(this);
    }

}
