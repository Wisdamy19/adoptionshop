package adoptionshop.adoptionshop.Controller;

import adoptionshop.adoptionshop.Model.Adoption_entity;
import adoptionshop.adoptionshop.Model.Customer_entity;
import adoptionshop.adoptionshop.Service.Adoption_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adoptions")
public class AdoptionController {
    @Autowired
    Adoption_service adoption_service;

    @PostMapping
    public Adoption_entity createAdoption(@RequestBody Adoption_entity adoption_entity){
        return adoption_service.save(adoption_entity);
    }

    @GetMapping
    public List<Adoption_entity> getAllAdoptions(){
        return adoption_service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Adoption_entity> getAdoptionById(@PathVariable int id){
        return adoption_service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAdoption (@PathVariable int id){
        adoption_service.delete(id);
        return "Customer with Id " + id + " has been deleted";

    }
}
