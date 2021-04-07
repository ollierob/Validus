package net.ollie.validus.project.git.jgit;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.git.GitlabProject;
import org.eclipse.jgit.transport.CredentialsProvider;

import java.io.File;
import java.net.URL;

public class JGitlabRemoteProject extends JGitRemoteProject implements GitlabProject {

    public JGitlabRemoteProject(
            final ProjectId id,
            final int version,
            final URL url,
            final String branch,
            final CredentialsProvider credentials,
            final File localRepoPath) {
        super(id, version, url, branch, credentials, localRepoPath);
    }

}
