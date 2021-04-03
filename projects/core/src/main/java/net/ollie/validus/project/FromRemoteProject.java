package net.ollie.validus.project;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public interface FromRemoteProject<L extends LocalProject> extends RemoteProject {

    @Nonnull
    RemoteProject source();

    @Nonnull
    @Override
    default CompletableFuture<L> toLocalProject() {
        return this.source().toLocalProject().thenApply(this::transform);
    }

    @Nonnull
    L transform(LocalProject project);

}
