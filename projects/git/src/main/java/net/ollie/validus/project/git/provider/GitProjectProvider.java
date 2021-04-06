package net.ollie.validus.project.git.provider;

import com.google.inject.ImplementedBy;
import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.git.GitProject;
import net.ollie.validus.project.git.GitlabProject;
import net.ollie.validus.project.provider.ProjectProvider;

import javax.annotation.Nonnull;

@ImplementedBy(DefaultGitProjectProvider.class)
public interface GitProjectProvider extends ProjectProvider<GitProject> {

    @Nonnull
    GitProject edit(ProjectId id, GitProjectSpec spec, int version);

    @Nonnull
    GitlabProject edit(ProjectId id, GitlabProjectSpec spec, int version);

}
