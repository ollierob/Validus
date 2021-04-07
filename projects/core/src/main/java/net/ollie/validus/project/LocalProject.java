package net.ollie.validus.project;

import javax.annotation.Nonnull;
import java.io.File;
import java.nio.file.Path;

public interface LocalProject extends Project {

    @Nonnull
    RemoteProject remote();

    @Nonnull
    File root();

    @Nonnull
    @Override
    default ProjectId id() {
        return this.remote().id();
    }

}
