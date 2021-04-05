package net.ollie.validus.server;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Named;

class ServerModule extends AbstractModule {

    private final ServerConfig config = new ServerConfig(System.getProperties());

    @Provides
    @Named("port")
    int port() {
        return config.port();
    }

}
