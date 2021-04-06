package net.ollie.validus.project;

import javax.annotation.Nonnull;
import java.net.URL;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public interface RemoteProject extends Project {

    int version();

    @Nonnull
    URL resolveUrl(Path filePath);

    @Nonnull
    CompletableFuture<? extends LocalProject> toLocalProject();

}
