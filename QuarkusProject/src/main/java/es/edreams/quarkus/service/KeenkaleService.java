package es.edreams.quarkus.service;

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

@RegisterRestClient
public interface KeenkaleService {
	
	/*
	namesAndValues.add("Content-Type","application/json");
	namesAndValues.add("Connection","Keep-Alive");
	namesAndValues.add("Accept-Charset","UTF-8");
	namesAndValues.add("Expect","x-openrtb-version: 2.4");
	namesAndValues.add("x-forwarded-for","216.15.125.142");
	namesAndValues.add("x-device-user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
	namesAndValues.add("x-original-user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
	 */
	
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
