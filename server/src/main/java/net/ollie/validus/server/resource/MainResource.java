package net.ollie.validus.server.resource;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Path("/")
public class MainResource extends AbstractResource{

    @GET
    @Produces(MediaType.TEXT_HTML)
    public InputStream main() {
        return this.readUnprotected("/website/main.html");
    }

    @GET
    @Path("js/{file:.+}")
    @Produces("application/javascript")
    public InputStream javascript(@PathParam("file") final String file) {
        if(file == null || !file.endsWith(".js") || file.startsWith(".")) throw new NotFoundException();
        return this.readUnprotected("/website/" + file);
    }

}
