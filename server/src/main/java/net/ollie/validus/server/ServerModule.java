package net.ollie.validus.server;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

import javax.inject.Named;

class ServerModule extends AbstractModule {

    private final ServerConfig config = new ServerConfig(System.getProperties());

    @Override
    protected void configure() {
        super.configure();
        this.bind(OpenApiResource.class); //Generate OpenAPI spec at /openapi.yaml
    }

    @Provides
    @Named("port")
    int port() {
        return config.port();
    }

}
