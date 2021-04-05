package net.ollie.validus.server;

import com.google.inject.Guice;
import org.eclipse.jetty.server.ResourceService;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.jboss.resteasy.plugins.server.servlet.FilterDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.DispatcherType;
import javax.servlet.Servlet;
import java.util.EnumSet;

public class Server {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    public static void main(final String[] args) {
        final var injector = Guice.createInjector(new ServerModule());
        injector.getInstance(Server.class).run();
    }

    private final int port;
    private final GuiceResteasyBootstrapServletContextListener contextListener;

    @Inject
    Server(@Named("port") final int port, final GuiceResteasyBootstrapServletContextListener contextListener) {
        this.port = port;
        this.contextListener = contextListener;
    }

    public void run() {

        try {

            logger.info("Running on port {}", port);
            final var server = new org.eclipse.jetty.server.Server(port);

            final var context = new ServletContextHandler();
            context.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false"); //Disable directory listings
            context.addEventListener(contextListener);
            context.addServlet(new ServletHolder(this.defaultServlet()), "/*");
            context.addFilter(new FilterHolder(FilterDispatcher.class), "/*", EnumSet.of(DispatcherType.REQUEST));

            final var gzipHandler = new GzipHandler();
            gzipHandler.setHandler(context);
            server.setHandler(gzipHandler);

            server.start();
            server.join();

        } catch (final Exception ex) {
            logger.error("Error running server", ex);
            throw new Error(ex);
        }

    }

    private Servlet defaultServlet() {
        final var resourceService = new ResourceService();
        resourceService.setEtags(true);
        return new DefaultServlet(resourceService);
    }

}
