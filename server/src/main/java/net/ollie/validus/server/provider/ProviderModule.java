package net.ollie.validus.server.provider;

import com.google.inject.AbstractModule;
import net.ollie.validus.project.provider.LocalProjectFileProvider;

public class ProviderModule extends AbstractModule {

    @Override
    protected void configure() {
        super.configure();
        this.bind(LocalProjectFileProvider.class).to(DefaultLocalProjectFileProvider.class);
    }

}
