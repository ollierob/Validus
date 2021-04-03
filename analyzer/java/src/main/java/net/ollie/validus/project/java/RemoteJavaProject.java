package net.ollie.validus.project.java;

import net.ollie.validus.project.FromRemoteProject;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public interface RemoteJavaProject extends JavaProject, FromRemoteProject<LocalJavaProject> {

    @Nonnull
    @Override
    default CompletableFuture<LocalJavaProject> toLocalProject() {
        return FromRemoteProject.super.toLocalProject();
    }

}
