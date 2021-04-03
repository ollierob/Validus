package net.ollie.validus.project;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public interface RemoteProject extends Project {

    @Nonnull
    CompletableFuture<? extends LocalProject> toLocalProject();

}
