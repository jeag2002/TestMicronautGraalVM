package io.helidon.examples.quickstart.se;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonObject;


import io.helidon.config.Config;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;


public class RTBService implements Service {
	
	private final static Logger LOGGER = Logger.getLogger(RTBService.class.getName());
	
	private static final String KEENKALE_CODE = "271";

	
    private static final Config CONFIG = Config.create().get("app");

    @Override
    public final void update(final Routing.Rules rules) {
        rules
            .get("/rtb/{name}", this::getMessage);
    }


    private void getMessage(final ServerRequest request,
                            final ServerResponse response) {
        String name = request.path().param("name");
        String msg = "";
        
        if (!name.equalsIgnoreCase(KEENKALE_CODE)) {
        	msg = String.format("Code (%s) not found!", name);
        }else {
        	msg = String.format("Code (%s) Response (%s)", name, processKeenKale());
        }
        
        LOGGER.info(msg);
        
        JsonObject returnObject = Json.createObjectBuilder()
                .add("message", msg)
                .build();
        response.send(returnObject);
    }
    
    
    
    public String processKeenKale() {
		  
		  
    	  String resp = "";
		  
    	  try {
    	  
			  String request = "{\"id\":\"dca01512ae9ce5b95712794dcd677d80\",\"imp\":[{\"id\":\"6bbc5bc3eb7081e1b7f4f7cc29b815f9\",\"instl\":0,\"tagid\":\"tx500674895\",\"bidfloor\":0.052500000000000005,\"bidfloorcur\":\"USD\",\"secure\":1,\"banner\":{\"id\":\"d06ca4a034793852b24a6bbc66e14690\",\"w\":320,\"h\":50,\"mimes\":[\"image/jpg\",\"image/gif\"],\"battr\":[],\"wmax\":320,\"hmax\":50,\"wmin\":300,\"hmin\":49,\"api\":[3,5]}}],\"device\":{\"ua\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36\",\"geo\":{\"country\":\"ESP\",\"lat\":41.427564,\"lon\":2.185005,\"type\":1},\"dnt\":0,\"lmt\":0,\"ip\":\"88.1.48.62\",\"devicetype\":4,\"make\":\"Samsung\",\"model\":\"gt-9300\",\"os\":\"Android\",\"osv\":\"4.4.4\",\"ifa\":\"1a58da58-4930-4adc-b1a4-2dc1ba386a96\",\"connectiontype\":2,\"js\":1,\"language\":\"es\"},\"test\":0,\"at\":1,\"tmax\":1500,\"badv\":[],\"app\":{\"id\":\"10308\",\"name\":\"Whatsdog\",\"publisher\":{\"id\":\"67fbd985230c665850075df702d12c5e\",\"name\":\"tappx\",\"domain\":\"tappx.com\"},\"bundle\":\"com.secondlemon.whatsdogpremium\",\"storeurl\":\"https://play.google.com/store/apps/details?id=com.secondlemon.whatsdogpremium\"},\"user\":{\"geo\":{\"country\":\"ESP\",\"lat\":41.427564,\"lon\":2.185005,\"type\":1}}}";
	
			  
			  CompletableFuture<HttpResponse<JsonNode>> future =
			  
			  Unirest.post("http://rtb-useast.keenkale.com/rtb?zone=55764")
			  .header("Connection","Keep-Alive")
			  .header("Accept-Charset","UTF-8")
			  .header("Expect","x-openrtb-version: 2.4")
			  .header("x-forwarded-for","216.15.125.142")
			  .header("x-device-user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36")
			  .header("x-original-user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36")
			  .body(request)
			  .asJsonAsync(
					  response->{
						  int code = response.getStatus();
						  JsonNode body = response.getBody()==null? new JsonNode("{\"message\":\"<EMPTY>\"}") : response.getBody(); 
					  }
			   );
			  
			   HttpResponse<JsonNode> node = future.get();
			   
			   resp = " HTTP Status [" + node.getStatus() +  "] Body (" +  node.getBody() + ")"; 
			   
    	  }catch(Exception e) {
    		  resp = "Something happened " +  e.getMessage();
    	  }
		   
		  return resp;
    }
    

}
