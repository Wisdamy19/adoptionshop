package adoptionshop.adoptionshop.Controller;

import adoptionshop.adoptionshop.Model.Animal_entity;
import adoptionshop.adoptionshop.Service.Animal_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    private Animal_service animal_service;

    @PostMapping
    public Animal_entity createAnimal(@RequestBody Animal_entity animal_entity){
        return animal_service.save(animal_entity);
    }
    @GetMapping
    public List<Animal_entity> getAllAnimals(){
        return animal_service.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Animal_entity> getAnimalById(@PathVariable int id) {
        return animal_service.findById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable int id) {
        animal_service.delete(id);
        return "Animal with ID " + id + " has been deleted";
    }


}
