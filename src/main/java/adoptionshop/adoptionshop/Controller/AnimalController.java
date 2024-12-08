package adoptionshop.adoptionshop.Controller;

import adoptionshop.adoptionshop.Model.AnimalEntity;
import adoptionshop.adoptionshop.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalEntity> createAnimal(@RequestBody AnimalEntity animalEntity){
        AnimalEntity savedAnimal = animalService.save(animalEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAnimal);
    }
    @GetMapping
    public ResponseEntity<List<AnimalEntity>> getAllAnimals(){
        List<AnimalEntity> getAllAnimals = animalService.findAll();
        if (getAllAnimals.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(getAllAnimals);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnimalEntity> getAnimalById(@PathVariable int id) {
        Optional<AnimalEntity> getAnimalById = animalService.findById(id);
        return getAnimalById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable int id) {
        animalService.delete(id);
        return "Animal with ID " + id + " has been deleted";
    }


}
