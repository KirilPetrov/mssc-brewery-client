package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "mssc.brewery", ignoreInvalidFields = false)
public class CustomerClient {

    private static final String API_URI = "/api/v1/customer/";
    public String apiServer;

    private RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiServer(String apiServer) {
        this.apiServer = apiServer;
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apiServer + API_URI + customerId.toString(), CustomerDto.class);
    }

    public URI createCustomer(CustomerDto customer) {
        return restTemplate.postForLocation(apiServer + API_URI, customer);
    }

    public void updateCustomer(UUID customerId, CustomerDto customer) {
        restTemplate.put(apiServer + API_URI + customerId.toString(), customer);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apiServer + API_URI + customerId.toString());
    }
}
