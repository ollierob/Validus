package net.ollie.validus.project.git.provider;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.git.GitProject;
import net.ollie.validus.project.git.GitlabProject;
import net.ollie.validus.project.provider.ProjectProvider;

import javax.annotation.Nonnull;

public interface GitProjectProvider extends ProjectProvider<GitProject> {

    interface Mutable extends GitProjectProvider, ProjectProvider.Mutable<GitProject> {

        @Nonnull
        GitlabProject edit(ProjectId id, GitlabProjectSpec spec);

    }

}
