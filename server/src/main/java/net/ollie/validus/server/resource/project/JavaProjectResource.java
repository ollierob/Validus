package net.ollie.validus.server.resource.project;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.java.RemoteJavaProject;
import net.ollie.validus.project.java.provider.JavaProjectProvider;
import net.ollie.validus.project.java.provider.JavaProjectSpec;
import net.ollie.validus.server.resource.AbstractResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static net.ollie.protobuf.jaxrs.ProtobufMediaType.APPLICATION_PROTOBUF;

@Singleton
@Path("project/java")
public class JavaProjectResource extends AbstractResource {

    private final JavaProjectProvider javaProvider;

    @Inject
    JavaProjectResource(final JavaProjectProvider javaProvider) {
        this.javaProvider = javaProvider;
    }

    @GET
    @Path("remote/{id}")
    @Produces(APPLICATION_PROTOBUF)
    public RemoteJavaProject get(@PathParam("id") final ProjectId id) {
        return javaProvider.get(id).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("remote/{id}")
    public RemoteJavaProject edit(
            @PathParam("id") final ProjectId id,
            @QueryParam("version") final int version,
            final JavaProjectSpec spec) {
        return javaProvider.edit(id, spec, version);
    }

}
