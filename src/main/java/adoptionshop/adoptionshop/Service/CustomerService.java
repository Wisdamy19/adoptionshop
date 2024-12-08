package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.Model.CustomerEntity;
import adoptionshop.adoptionshop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    private CustomerEntity customerEntity;

    public List<CustomerEntity> findall(){
        return customerRepository.findAll();
    }
    public CustomerEntity save(CustomerEntity customerEntity){
            return customerRepository.save(customerEntity);
    }
    public Optional<CustomerEntity> findById(int id){
        return customerRepository.findById(id);
    }
    public void delete(int id){
        customerRepository.deleteById(id);
    }

}
