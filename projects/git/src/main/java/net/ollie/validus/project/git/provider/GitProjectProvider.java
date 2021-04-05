package net.ollie.validus.project.git.provider;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.git.GitProject;
import net.ollie.validus.project.git.GitlabProject;
import net.ollie.validus.project.provider.ProjectProvider;

public interface GitProjectProvider extends ProjectProvider<GitProject> {

    interface Mutable extends GitProjectProvider, ProjectProvider.Mutable<GitProject> {

        GitlabProject set(ProjectId id, GitlabProjectSpec spec);

    }

}
