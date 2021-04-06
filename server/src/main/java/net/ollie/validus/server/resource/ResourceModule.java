package net.ollie.validus.server.resource;

import com.google.inject.AbstractModule;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import net.ollie.validus.server.resource.project.GitProjectResource;
import net.ollie.validus.server.resource.project.JavaProjectResource;

public class ResourceModule extends AbstractModule {

    @Override
    protected void configure() {
        super.configure();
        this.bind(OpenApiResource.class); //Generate OpenAPI spec at /openapi.yaml
        this.bind(JavaProjectResource.class);
        this.bind(GitProjectResource.class);
    }

}
