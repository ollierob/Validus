package net.ollie.validus.project.git.jgit;

import net.ollie.validus.project.LocalProject;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.File;

public class JGitLocalProject implements LocalProject {

    private static final Logger logger = LoggerFactory.getLogger(JGitLocalProject.class);

    private final JGitRemoteProject remote;
    private final File localRepoPath;
    private Git git;

    JGitLocalProject(final JGitRemoteProject remote, final File localRepoPath) {
        this.remote = remote;
        this.localRepoPath = localRepoPath;
    }

    synchronized void refresh() {
        try {
            if (git == null) {
                if (!this.doOpen()) this.doClone();
            } else {
                git.pull().call();
            }
        } catch (final Exception gex) {
            throw new RuntimeException(gex);
        }
    }

    private boolean doOpen() {
        try {
            if (localRepoPath.exists()) {
                logger.info("{}: opening {}", this.id(), localRepoPath);
                git = Git.open(localRepoPath);
                return true;
            } else {
                return false;
            }
        } catch (final Exception ex) {
            logger.warn("Could not open Git repo", ex);
            return false;
        }
    }

    private void doClone() throws GitAPIException {
        logger.info("{}: cloning {}", this.id(), localRepoPath);
        git = remote.cloneCommand(localRepoPath).call();
    }

    @Nonnull
    @Override
    public JGitRemoteProject remote() {
        return remote;
    }

    @Nonnull
    @Override
    public File root() {
        return localRepoPath;
    }

}
