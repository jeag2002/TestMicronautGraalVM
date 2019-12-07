/*
 * Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.helidon.examples.quickstart.mp;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;




@Path("/rtbdispatcher")
@RequestScoped
public class RTBResource {
	
	private final static Logger LOGGER = Logger.getLogger(RTBResource.class.getName());
	
	@Inject
	@RestClient
	KeenkaleService keenService;
	

	private static final String KEENKALE_CODE = "271";

    @SuppressWarnings("checkstyle:designforextension")
    @Path("/rtb/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getMessage(@PathParam("name") final String name) {
        
    	 String msg = "";
    	
    	 if (!name.equalsIgnoreCase(KEENKALE_CODE)) {
         	msg = String.format("Code (%s) not found!", name);
         }else {
         	msg = String.format("Code (%s) Response (%s)",name,processKeenKale());
         }
    	 
    	 LOGGER.info(msg);
         
        JsonObject returnObject = Json.createObjectBuilder()
                .add("message", msg)
                .build();
        return returnObject;
    }
    
    
    public String processKeenKale() {
    	
    	String request = "{\"id\":\"dca01512ae9ce5b95712794dcd677d80\",\"imp\":[{\"id\":\"6bbc5bc3eb7081e1b7f4f7cc29b815f9\",\"instl\":0,\"tagid\":\"tx500674895\",\"bidfloor\":0.052500000000000005,\"bidfloorcur\":\"USD\",\"secure\":1,\"banner\":{\"id\":\"d06ca4a034793852b24a6bbc66e14690\",\"w\":320,\"h\":50,\"mimes\":[\"image/jpg\",\"image/gif\"],\"battr\":[],\"wmax\":320,\"hmax\":50,\"wmin\":300,\"hmin\":49,\"api\":[3,5]}}],\"device\":{\"ua\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36\",\"geo\":{\"country\":\"ESP\",\"lat\":41.427564,\"lon\":2.185005,\"type\":1},\"dnt\":0,\"lmt\":0,\"ip\":\"88.1.48.62\",\"devicetype\":4,\"make\":\"Samsung\",\"model\":\"gt-9300\",\"os\":\"Android\",\"osv\":\"4.4.4\",\"ifa\":\"1a58da58-4930-4adc-b1a4-2dc1ba386a96\",\"connectiontype\":2,\"js\":1,\"language\":\"es\"},\"test\":0,\"at\":1,\"tmax\":1500,\"badv\":[],\"app\":{\"id\":\"10308\",\"name\":\"Whatsdog\",\"publisher\":{\"id\":\"67fbd985230c665850075df702d12c5e\",\"name\":\"tappx\",\"domain\":\"tappx.com\"},\"bundle\":\"com.secondlemon.whatsdogpremium\",\"storeurl\":\"https://play.google.com/store/apps/details?id=com.secondlemon.whatsdogpremium\"},\"user\":{\"geo\":{\"country\":\"ESP\",\"lat\":41.427564,\"lon\":2.185005,\"type\":1}}}";
		
		String contentType = "application/json";
	    String connection = "Keep-Alive";
		String acceptCharset = "UTF-8";
		String expect = "x-openrtb-version: 2.4";
		String xforwardedfor = "216.15.125.142";
		String xdeviceuseragent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36";
		String xoriginaluseragent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36";
		
		Response response = keenService.getAdvertisement(
			    contentType,
			    connection,
			    acceptCharset,
			    expect,
				xforwardedfor,
				xdeviceuseragent,
				xoriginaluseragent,
				request);
		
		if (response == null) {
			return "response object is Null";
		}else{
			String value = response.getStatus() + " " + (response.getEntity() != null? response.readEntity(String.class) : "<Empty>");
			return value;
		}
    	
    }
    
    
    /*
    public String processKeenKale() {
    	
    	
    	try {
    	
	    	KeenkaleService client = RestClientBuilder.newBuilder()
	    							 .baseUri(new URI("http://rtb-useast.keenkale.com/rtb?zone=55764"))
	    							 .build(KeenkaleService.class);
	    	
	    	
	    	
	    	String request = "{\"id\":\"dca01512ae9ce5b95712794dcd677d80\",\"imp\":[{\"id\":\"6bbc5bc3eb7081e1b7f4f7cc29b815f9\",\"instl\":0,\"tagid\":\"tx500674895\",\"bidfloor\":0.052500000000000005,\"bidfloorcur\":\"USD\",\"secure\":1,\"banner\":{\"id\":\"d06ca4a034793852b24a6bbc66e14690\",\"w\":320,\"h\":50,\"mimes\":[\"image/jpg\",\"image/gif\"],\"battr\":[],\"wmax\":320,\"hmax\":50,\"wmin\":300,\"hmin\":49,\"api\":[3,5]}}],\"device\":{\"ua\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36\",\"geo\":{\"country\":\"ESP\",\"lat\":41.427564,\"lon\":2.185005,\"type\":1},\"dnt\":0,\"lmt\":0,\"ip\":\"88.1.48.62\",\"devicetype\":4,\"make\":\"Samsung\",\"model\":\"gt-9300\",\"os\":\"Android\",\"osv\":\"4.4.4\",\"ifa\":\"1a58da58-4930-4adc-b1a4-2dc1ba386a96\",\"connectiontype\":2,\"js\":1,\"language\":\"es\"},\"test\":0,\"at\":1,\"tmax\":1500,\"badv\":[],\"app\":{\"id\":\"10308\",\"name\":\"Whatsdog\",\"publisher\":{\"id\":\"67fbd985230c665850075df702d12c5e\",\"name\":\"tappx\",\"domain\":\"tappx.com\"},\"bundle\":\"com.secondlemon.whatsdogpremium\",\"storeurl\":\"https://play.google.com/store/apps/details?id=com.secondlemon.whatsdogpremium\"},\"user\":{\"geo\":{\"country\":\"ESP\",\"lat\":41.427564,\"lon\":2.185005,\"type\":1}}}";
			
			String contentType = "application/json";
		    String connection = "Keep-Alive";
			String acceptCharset = "UTF-8";
			String expect = "x-openrtb-version: 2.4";
			String xforwardedfor = "216.15.125.142";
			String xdeviceuseragent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36";
			String xoriginaluseragent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36";
			
			Response response =  client.getAdvertisement(
				    contentType,
				    connection,
				    acceptCharset,
				    expect,
					xforwardedfor,
					xdeviceuseragent,
					xoriginaluseragent,
					request);
			
			if (response == null) {
				return "response object is Null";
			}else{
				String value = response.getStatus() + " " + (response.getEntity() != null? response.readEntity(String.class) : "<Empty>");
				return value;
			}
		
    	}catch(Exception e) {
    		return "response object error " +  e.getMessage();
    	}
    }
    */
	
	
   
}
