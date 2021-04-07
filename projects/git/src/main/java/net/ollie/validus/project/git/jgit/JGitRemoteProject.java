package net.ollie.validus.project.git.jgit;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.git.GitProject;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.CredentialsProvider;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class JGitRemoteProject implements GitProject {

    private final ProjectId id;
    private final int version;
    private final URL url;
    private final String branch;
    private final CredentialsProvider credentials;
    private final File localRepoPath;

    public JGitRemoteProject(
            final ProjectId id,
            final int version,
            final URL url,
            final String branch,
            final CredentialsProvider credentials,
            final File localRepoPath) {
        this.id = id;
        this.version = version;
        this.url = url;
        this.branch = branch;
        this.credentials = credentials;
        this.localRepoPath = localRepoPath;
    }

    @Override
    public ProjectId id() {
        return id;
    }

    @Override
    public int version() {
        return version;
    }

    @Override
    public URL resolveUrl(final Path filePath) {
        return null;
    }

    protected CloneCommand cloneCommand(final File localRepoPath) {
        return Git.cloneRepository()
                .setURI(url.toExternalForm())
                .setCredentialsProvider(credentials)
                .setDirectory(localRepoPath)
                .setBranch(branch);
    }

    private JGitLocalProject local;

    @Override
    public synchronized CompletableFuture<JGitLocalProject> toLocalProject() {
        if (local == null) local = new JGitLocalProject(this, localRepoPath);
        return CompletableFuture.runAsync(local::refresh).thenApply(v -> local);
    }

}
