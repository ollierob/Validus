package net.ollie.validus.project;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public interface LocalProject extends Project {

    @Nonnull
    @Override
    @Deprecated
    default CompletableFuture<? extends LocalProject> toLocalProject() {
        return CompletableFuture.completedFuture(this);
    }

}
