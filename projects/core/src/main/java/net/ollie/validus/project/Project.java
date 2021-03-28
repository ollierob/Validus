package net.ollie.validus.project;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public interface Project {

    @Nonnull
    ProjectId id();

    @Nonnull
    CompletableFuture<LocalProject> toLocalProject();

}