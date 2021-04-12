package net.ollie.validus.server.resource.project;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.git.GitlabProject;
import net.ollie.validus.project.git.provider.GitProjectProvider;
import net.ollie.validus.project.git.provider.GitlabProjectSpec;
import net.ollie.validus.server.authentication.context.AuthenticationContext;
import net.ollie.validus.server.resource.AbstractResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import static net.ollie.protobuf.jaxrs.ProtobufMediaType.APPLICATION_PROTOBUF;

@Singleton
@Path("project/git")
public class GitProjectResource extends AbstractResource {

    private final GitProjectProvider provider;

    @Inject
    GitProjectResource(final GitProjectProvider provider) {
        this.provider = provider;
    }

    @GET
    @Path("gitlab/{id}")
    public GitlabProject getGitlabProject(
            @PathParam("id") final ProjectId id,
            @Context final AuthenticationContext authenticationContext) {
        return provider.get(id, GitlabProject.class).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("gitlab/{id}")
    @Produces(APPLICATION_PROTOBUF)
    @Consumes(APPLICATION_PROTOBUF)
    public GitlabProject editGitlabProject(
            @PathParam("id") final ProjectId id,
            @QueryParam("version") final int version,
            final GitlabProjectSpec spec) {
        return provider.edit(id, spec, version);
    }

}
