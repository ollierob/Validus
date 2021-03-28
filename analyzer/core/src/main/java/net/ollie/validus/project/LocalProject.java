package net.ollie.validus.project;

import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public record LocalProject(ProjectId id, Path root, Project source) implements Project {

    @Nonnull
    @Override
    @Deprecated
    public CompletableFuture<LocalProject> toLocalProject() {
        return CompletableFuture.completedFuture(this);
    }

}
