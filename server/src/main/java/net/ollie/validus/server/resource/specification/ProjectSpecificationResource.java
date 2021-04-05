package net.ollie.validus.server.resource.specification;

import net.ollie.validus.project.ProjectId;
import net.ollie.validus.server.resource.AbstractResource;
import net.ollie.validus.specification.Specification;
import net.ollie.validus.specification.SpecificationId;
import net.ollie.validus.specification.SpecificationProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static net.ollie.protobuf.jaxrs.ProtobufMediaType.APPLICATION_PROTOBUF;

public class ProjectSpecificationResource extends AbstractResource {

    private final ProjectId id;
    private final SpecificationProvider specificationProvider;

    public ProjectSpecificationResource(
            final ProjectId id,
            final SpecificationProvider specificationProvider) {
        this.id = id;
        this.specificationProvider = specificationProvider;
    }

    @GET
    @Produces({MediaType.TEXT_PLAIN, APPLICATION_PROTOBUF})
    @Path("get/{id}")
    public Specification get(@PathParam("id") final SpecificationId id) {
        return specificationProvider.require(id);
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("set/{id}/description")
    public Specification set(@PathParam("id") final SpecificationId id, final String description) {
        throw new UnsupportedOperationException();
    }

}
