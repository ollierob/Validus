package net.ollie.validus.project.git.provider;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.git.GitProject;
import net.ollie.validus.project.git.GitlabProject;
import net.ollie.validus.project.provider.RemoteProjectProvider;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class DefaultGitProjectProvider implements GitProjectProvider {

    private final RemoteProjectProvider remote;

    @Inject
    DefaultGitProjectProvider(final RemoteProjectProvider remote) {
        this.remote = remote;
    }

    @Nonnull
    @Override
    public Optional<GitProject> get(final ProjectId id) {
        return remote.get(id, GitProject.class);
    }

    @Nonnull
    @Override
    public GitProject edit(final ProjectId id, final GitProjectSpec spec, final int version) {
        throw new UnsupportedOperationException(); //TODO
    }

    @Nonnull
    @Override
    public GitlabProject edit(final ProjectId id, final GitlabProjectSpec spec, final int version) {
        throw new UnsupportedOperationException(); //TODO
    }

}
