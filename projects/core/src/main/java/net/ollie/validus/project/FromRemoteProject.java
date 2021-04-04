package net.ollie.validus.project;

import javax.annotation.Nonnull;
import java.net.URL;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public interface FromRemoteProject<L extends LocalProject> extends RemoteProject {

    @Nonnull
    RemoteProject remote();

    @Nonnull
    @Override
    default ProjectId id() {
        return this.remote().id();
    }

    @Nonnull
    @Override
    default CompletableFuture<L> toLocalProject() {
        return this.remote().toLocalProject().thenApply(this::transform);
    }

    @Nonnull
    L transform(LocalProject project);

    @Nonnull
    @Override
    default URL resolveUrl(final Path filePath) {
        return this.remote().resolveUrl(filePath);
    }

}
