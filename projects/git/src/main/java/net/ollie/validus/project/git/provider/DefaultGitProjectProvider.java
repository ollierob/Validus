package net.ollie.validus.project.git.provider;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.git.GitProject;
import net.ollie.validus.project.git.GitlabProject;
import net.ollie.validus.project.git.credentials.GitCredentials;
import net.ollie.validus.project.git.credentials.GitTokenCredentials;
import net.ollie.validus.project.git.credentials.GitUsernamePasswordCredentials;
import net.ollie.validus.project.git.jgit.JGitRemoteProject;
import net.ollie.validus.project.provider.LocalProjectFileProvider;
import net.ollie.validus.project.provider.RemoteProjectProvider;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class DefaultGitProjectProvider implements GitProjectProvider {

    private final RemoteProjectProvider remote;
    private final LocalProjectFileProvider fileProvider;

    @Inject
    DefaultGitProjectProvider(
            final RemoteProjectProvider remote,
            final LocalProjectFileProvider fileProvider) {
        this.remote = remote;
        this.fileProvider = fileProvider;
    }

    @Nonnull
    @Override
    public Optional<GitProject> get(final ProjectId id) {
        return remote.get(id, GitProject.class);
    }

    @Nonnull
    @Override
    public GitProject edit(final ProjectId id, final GitProjectSpec spec, final int version) {
        final var localRepo = fileProvider.get(id);
        final var credentials = this.credentials(spec.credentials());
        final var project = new JGitRemoteProject(id, version + 1, spec.url(), spec.branch(), credentials, localRepo);
        return remote.edit(project, version);
    }

    protected CredentialsProvider credentials(final GitCredentials credentials) {
        if (credentials instanceof GitUsernamePasswordCredentials up) return new UsernamePasswordCredentialsProvider(up.username(), up.password());
        if (credentials instanceof GitTokenCredentials t) return new UsernamePasswordCredentialsProvider(t.username(), t.token());
        throw new UnsupportedOperationException();
    }

    @Nonnull
    @Override
    public GitlabProject edit(final ProjectId id, final GitlabProjectSpec spec, final int version) {
        final var localRepo = fileProvider.get(id);
        final var credentials = this.credentials(spec.credentials());
        throw new UnsupportedOperationException(); //TODO
    }

}
