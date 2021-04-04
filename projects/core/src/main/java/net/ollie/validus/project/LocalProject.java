package net.ollie.validus.project;

import javax.annotation.Nonnull;

public interface LocalProject extends Project {

    @Nonnull
    RemoteProject remote();

    @Nonnull
    @Override
    default ProjectId id() {
        return this.remote().id();
    }

}
