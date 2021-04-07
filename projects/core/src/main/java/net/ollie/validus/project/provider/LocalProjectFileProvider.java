package net.ollie.validus.project.provider;

import net.ollie.validus.project.ProjectId;

import javax.annotation.Nonnull;
import java.io.File;

public interface LocalProjectFileProvider {

    @Nonnull
    File get(@Nonnull ProjectId id);

}
