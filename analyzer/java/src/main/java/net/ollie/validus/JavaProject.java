package net.ollie.validus;

import net.ollie.validus.project.Project;

import javax.annotation.Nonnull;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

public interface JavaProject extends Project {

    @Nonnull
    URL resolveUrl(JavaMethod method);

    @Nonnull
    @Override
    CompletableFuture<? extends LocalJavaProject> toLocalProject();

}
