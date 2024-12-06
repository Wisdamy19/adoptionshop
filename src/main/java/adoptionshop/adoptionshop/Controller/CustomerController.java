package adoptionshop.adoptionshop.Controller;

import adoptionshop.adoptionshop.Model.Customer_entity;
import adoptionshop.adoptionshop.Service.Customer_service;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private Customer_service customerService;

    @PostMapping
    public Customer_entity createCustomer(@RequestBody Customer_entity customer_entity){
        return customerService.save(customer_entity);
    }
    @GetMapping
    public List<Customer_entity> getAllAnimals(){
        return customerService.findall();
    }
    @GetMapping("/{id}")
    public Optional<Customer_entity> getCustomerById(@PathVariable int id){
        return customerService.findById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer (@PathVariable int id){
        customerService.delete(id);
        return "Customer with Id " + id + " has been deleted";

    }
}
