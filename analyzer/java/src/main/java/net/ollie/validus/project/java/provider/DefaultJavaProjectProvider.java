package net.ollie.validus.project.java.provider;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.java.RemoteJavaProject;
import net.ollie.validus.project.provider.RemoteProjectProvider;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class DefaultJavaProjectProvider implements JavaProjectProvider {

    private final RemoteProjectProvider delegate;

    @Inject
    DefaultJavaProjectProvider(final RemoteProjectProvider delegate) {
        this.delegate = delegate;
    }

    @Nonnull
    @Override
    public RemoteJavaProject edit(final ProjectId id, final JavaProjectSpec spec, final int version) {
        final var remote = delegate.require(spec.remoteId());
        final var project = new RemoteJavaProject(id, remote, version + 1);
        return delegate.edit(project, version);
    }

    @Nonnull
    @Override
    public Optional<RemoteJavaProject> get(final ProjectId id) {
        return delegate.get(id, RemoteJavaProject.class);
    }

}
