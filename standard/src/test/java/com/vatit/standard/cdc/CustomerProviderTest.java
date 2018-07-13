package com.vatit.standard.cdc;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import com.vatit.standard.controllers.CustomerController;
import com.vatit.standard.entities.Customer;
import com.vatit.standard.repository.CustomerRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(RestPactRunner.class)
@Provider("customer_provider")
@PactFolder("target/pacts")
public class CustomerProviderTest {
    @InjectMocks
    private CustomerController customerController = new CustomerController();
    @Mock
    private CustomerRepository customerRepository;
    @TestTarget
    public final MockMvcTarget target = new MockMvcTarget();

    @org.junit.Before
    public void before() {
        initMocks(this);
        target.setControllers(customerController);
    }

    @State("customers data")
    public void customerData() {

        List<Customer> data = new ArrayList<>();
        when(customerRepository.findAll())
                .thenReturn(data);
    }
}


