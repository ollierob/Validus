package net.ollie.validus.server;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Named;

class ServerModule extends AbstractModule {

    @Provides
    @Named("port")
    int port() {
        return 9080;
    }

}
