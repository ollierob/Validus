package net.ollie.validus.server.provider;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.provider.LocalProjectFileProvider;

import javax.annotation.Nonnull;
import java.io.File;

public class DefaultLocalProjectFileProvider implements LocalProjectFileProvider {

    @Nonnull
    @Override
    public File get(@Nonnull ProjectId id) {
        throw new UnsupportedOperationException();
    }

}
