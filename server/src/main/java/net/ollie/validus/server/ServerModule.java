package net.ollie.validus.server;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import net.ollie.validus.project.git.GitProjectModule;
import net.ollie.validus.project.java.JavaProjectModule;
import net.ollie.validus.server.authentication.AuthenticationModule;
import net.ollie.validus.server.provider.ProviderModule;
import net.ollie.validus.server.resource.ResourceModule;

import javax.inject.Named;

class ServerModule extends AbstractModule {

    private final ServerConfig config = new ServerConfig(System.getProperties());

    @Override
    protected void configure() {
        super.configure();
        this.install(new ProviderModule());
        this.install(new ResourceModule());
        this.install(new AuthenticationModule());
        this.install(new GitProjectModule());
        this.install(new JavaProjectModule());
    }

    @Provides
    @Named("port")
    int port() {
        return config.port();
    }

}
