package es.edreams.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import es.edreams.quarkus.service.QuarkusService;

@Path("/rtbdispatcher")
public class RTBDispatcher {

	private static final String KEENKALEID = "271";
	
	private final static Logger LOGGER = Logger.getLogger(RTBDispatcher.class.getName());
	
	@Inject
	QuarkusService qService;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/rtb/{name}")
    public String rtb(@PathParam("name") String name) {
    	
    	String response = "";
    	
	    if (name != null) {
	    	if (!name.trim().equalsIgnoreCase(KEENKALEID)) {
	    		response =  "RTB Code (" +  name + ") Not found";
	    	}else {
	    		response =  "RTB Code (" + name + ") return (" + qService.processKeenKale() + ")";
	    	}
	    }else {
	    	response =  "RTB Code null";	
	    }
	    
	    LOGGER.info(response);
	    return response;
    }
}