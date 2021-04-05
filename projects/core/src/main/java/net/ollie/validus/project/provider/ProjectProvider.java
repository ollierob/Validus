package net.ollie.validus.project.provider;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.RemoteProject;

import javax.annotation.Nonnull;
import java.util.Optional;

public interface ProjectProvider<P extends RemoteProject> {

    @Nonnull
    Optional<P> get(ProjectId id);

    @Nonnull
    default P require(final ProjectId id) {
        return this.get(id).get();
    }

    interface Mutable<P extends RemoteProject> extends ProjectProvider<P> {

    }

}
