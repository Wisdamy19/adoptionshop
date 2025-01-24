package adoptionshop.adoptionshop.Controller;

import adoptionshop.adoptionshop.Model.CustomerEntity;
import adoptionshop.adoptionshop.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer_entity){
        CustomerEntity savedCustomer = customerService.save(customer_entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAllCustomers(){
        List<CustomerEntity> getAllCustomers = customerService.findall();
        if (getAllCustomers.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(getAllCustomers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id){
        Optional<CustomerEntity> getCustomerById = customerService.findById(id);
        return getCustomerById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer (@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.ok(+ id + " has been deleted");

    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable Long id, @RequestBody CustomerEntity updatedCustomer){
        Optional<CustomerEntity> existingCustomerOp = customerService.findById(id);
        if (!existingCustomerOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        CustomerEntity existingCustomer = existingCustomerOp.get();

        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPassword(updatedCustomer.getPassword());
        existingCustomer.setTelephone(updatedCustomer.getTelephone());
        existingCustomer.setCpf(updatedCustomer.getCpf());

        CustomerEntity savedCustomer = customerService.updateCustomer(existingCustomer);
        return ResponseEntity.ok(savedCustomer);

    }
}
