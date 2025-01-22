package adoptionshop.adoptionshop.CustomerServiceTest;


import adoptionshop.adoptionshop.Model.CustomerEntity;
import adoptionshop.adoptionshop.Repository.CustomerRepository;
import adoptionshop.adoptionshop.Service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testCreateCustomer(){
        CustomerEntity customer = new CustomerEntity(null, "Antônio", "antoniowis2019@gmail.com", "1234", "82 9999", "11051092400", null);
        CustomerEntity savedCustomer = new CustomerEntity(1L, "Antônio", "antoniowis2019@gmail.com", "1234", "82 9999", "11051092400", null);

        Mockito.when(customerRepository.save(customer)).thenReturn(savedCustomer);

        CustomerEntity result = customerService.save(customer);
        assertNotNull(result.getId());
        assertEquals("Antônio", result.getName());
    }
    @Test
    public void testGetAllCustomers(){
        List<CustomerEntity> customers = List.of(new CustomerEntity(1L, "Antônio", "antoniowis2019@gmail.com", "1234", "82 9999", "11051092400", null),
        new CustomerEntity(2L, "John", "johndoe2019@gmail.com", "1234", "82 9999", "11051092400", null));

        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerEntity> result = customerService.findall();
        assertEquals(2, result.size());
        assertEquals("Antônio", result.get(0).getName());
    }

}
