package net.ollie.validus.server.resource.project;

import net.ollie.validus.GitProjectProto;
import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.git.GitlabProject;
import net.ollie.validus.project.git.provider.GitProjectProvider;
import net.ollie.validus.project.git.provider.GitlabProjectSpec;
import net.ollie.validus.server.resource.AbstractResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Singleton
@Path("project/git")
public class GitProjectResource extends AbstractResource {

    private final GitProjectProvider.Mutable provider;

    @Inject
    GitProjectResource(final GitProjectProvider.Mutable provider) {
        this.provider = provider;
    }

    @PUT
    @Path("edit/gitlab/{id}")
    public GitlabProject editGitlabProject(
            @PathParam("id") final ProjectId id,
            @QueryParam("version") @DefaultValue("0") final int version,
            final GitProjectProto.GitlabProjectSpec spec) {
        return provider.set(id, new GitlabProjectSpec(version));
    }

}
