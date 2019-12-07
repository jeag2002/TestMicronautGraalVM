package io.helidon.examples.quickstart.mp;

import java.util.Set;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri="http://rtb-useast.keenkale.com/rtb?zone=55764")
public interface KeenkaleService {
	
    @OPTIONS
    Response options();

    @HEAD
    Response head();
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@ClientHeaderParam(name="X-Log-Level", value="DEBUG")
	Response getAdvertisement(
			@HeaderParam("Content-Type") String contentType,
			@HeaderParam("Connection") String connection,
			@HeaderParam("Accept-Charset") String acceptCharset,
			@HeaderParam("Expect") String expect,
			@HeaderParam("x-forwarded-for") String xforwardedfor,
			@HeaderParam("x-device-user-agent") String xdeviceuseragent,
			@HeaderParam("x-original-user-agent") String xoriginaluseragent,
			String entity);
	
	
}
