package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    public void getCustomerById() {
        CustomerDto customer = customerClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customer);
    }

    @Test
    public void createCustomer() {
        URI uri = customerClient.createCustomer(CustomerDto.builder().build());

        assertNotNull(uri);
    }

    @Test
    public void updateCustomer() {
        customerClient.updateCustomer(UUID.randomUUID(), CustomerDto.builder().build());
    }

    @Test
    public void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}