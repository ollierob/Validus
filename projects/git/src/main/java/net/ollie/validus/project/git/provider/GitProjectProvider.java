package net.ollie.validus.project.git.provider;

import net.ollie.validus.project.git.GitProject;
import net.ollie.validus.project.git.GitlabProject;
import net.ollie.validus.project.provider.ProjectProvider;

import javax.annotation.Nonnull;

public interface GitProjectProvider extends ProjectProvider<GitProject> {

    interface Mutable extends GitProjectProvider, ProjectProvider.Mutable<GitProject> {

        @Nonnull
        GitProject edit(@Nonnull GitProjectSpec spec);

        @Nonnull
        GitlabProject edit(@Nonnull GitlabProjectSpec spec);

    }

}
