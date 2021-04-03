package net.ollie.validus.project;

import javax.annotation.Nonnull;

public interface LocalProject extends Project {

    @Nonnull
    @Override
    default ProjectId id() {
        return this.remote().id();
    }

    @Nonnull
    RemoteProject remote();

}
