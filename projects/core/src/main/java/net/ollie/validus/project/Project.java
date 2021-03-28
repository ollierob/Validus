package net.ollie.validus.project;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public sealed interface Project permits LocalProject {

    @Nonnull
    ProjectId id();

    @Nonnull
    CompletableFuture<LocalProject> toLocalProject();

}