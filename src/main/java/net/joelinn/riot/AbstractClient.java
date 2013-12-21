package net.joelinn.riot;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;

/**
 * Joe Linn
 * 12/10/13
 */
public abstract class AbstractClient {

    protected static final String BASE_URL = "https://prod.api.pvp.net/api/";

    protected String apiKey;

    protected Region region;

    protected WebResource service;

    /**
     * @param apiKey your Riot API key
     * @param region {@link Region}
     */
    public AbstractClient(String apiKey, Region region){
        this.apiKey = apiKey;

        ClientConfig config = new DefaultClientConfig();
        ObjectMapper mapper = new ObjectMapper();
        JacksonJsonProvider provider = new JacksonJsonProvider(mapper);
        config.getSingletons().add(provider);
        Client client = Client.create(config);
        service = client.resource(UriBuilder.fromUri(getBaseUrl()).build());
        setRegion(region);
    }

    protected String getBaseUrl(){
        return BASE_URL + "lol/";
    }

    /**
     * @return the version number of the API ("1.1", "2.3", for example)
     */
    protected abstract String getVersion();

    /**
     * @param region {@link Region}
     * @return the current AbstractClient object instantiation
     */
    public AbstractClient setRegion(Region region) {
        this.region = region;
        return this;
    }

    public Region getRegion(){
        return region;
    }

    protected ClientResponse get(String url){
        return get(url, null);
    }

    protected ClientResponse get(String url, MultivaluedMapImpl queryParams){
        return request("GET", url, queryParams);
    }

    protected ClientResponse post(String url, MultivaluedMapImpl data){
        return request("POST", url, null, data);
    }

    protected ClientResponse put(String url, MultivaluedMapImpl data){
        return request("PUT", url, null, data);
    }

    protected ClientResponse delete(String url){
        return request("DELETE", url);
    }

    protected ClientResponse request(String method, String url){
        return request(method, url, null);
    }

    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams){
        return request(method, url, queryParams, null);
    }

    protected ClientResponse request(String method, String url, MultivaluedMapImpl queryParams, MultivaluedMapImpl data){
        if(region == null){
            throw new RuntimeException("region must be set in order to perform api operations!");
        }
        if(queryParams == null){
            queryParams = new MultivaluedMapImpl();
        }
        queryParams.add("api_key", this.apiKey);
        ClientResponse clientResponse = getResourceBuilder(this.region + "/v" + getVersion() + "/" + url, queryParams).method(method, ClientResponse.class, data);
        checkForErrors(clientResponse);
        return clientResponse;
    }

    private void checkForErrors(ClientResponse clientResponse){
        if(clientResponse.getClientResponseStatus().getStatusCode() != ClientResponse.Status.OK.getStatusCode()
                && clientResponse.getClientResponseStatus().getStatusCode() != ClientResponse.Status.CREATED.getStatusCode()){
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
            try {
                throw new ApiException(clientResponse.getClientResponseStatus(),
                        objectMapper.readValue(clientResponse.getEntity(String.class), Error.class).message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private WebResource.Builder getResourceBuilder(String url, MultivaluedMapImpl queryParams){
        WebResource webResource = service.path(url);
        if(queryParams != null){
            webResource = webResource.queryParams(queryParams);
        }
        return webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_FORM_URLENCODED);
    }
}
