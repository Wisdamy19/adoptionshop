package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.Model.Customer_entity;
import adoptionshop.adoptionshop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Customer_service {
    @Autowired
    private CustomerRepository customerRepository;

    private Customer_entity customer_entity;

    public List<Customer_entity> findall(){
        return customerRepository.findAll();
    }
    public Customer_entity save(Customer_entity customer_entity){
        if (customer_entity.getName() == null || customer_entity.getName().trim().isEmpty()){
            return null;
        }
        if (customer_entity.getName().length() > 45){
            return null;
        }
            return customerRepository.save(customer_entity);
    }
    public Optional<Customer_entity> findById(int id){
        return customerRepository.findById(id);
    }
    public void delete(int id){
        customerRepository.deleteById(id);
    }

}
