package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.Model.CustomerEntity;
import adoptionshop.adoptionshop.Repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    private CustomerEntity customerEntity;

    public List<CustomerEntity> findall(){
        return customerRepository.findAll();
    }
    public CustomerEntity save(CustomerEntity customerEntity){
            return customerRepository.save(customerEntity);
    }
    public Optional<CustomerEntity> findById(Long id){
        return customerRepository.findById(id);
    }
    public void delete(Long id){
        customerRepository.deleteById(id);
    }
    public CustomerEntity updateCustomer(CustomerEntity customerEntity){
        if (customerEntity == null || customerEntity.getId() == null){
            throw new IllegalArgumentException("Invalid.");
        }
        if (!customerRepository.existsById(customerEntity.getId())){
            throw new EntityNotFoundException("Customer with ID " + customerEntity.getId() + "not found");
        }
        return customerRepository.save(customerEntity);
    }

}
