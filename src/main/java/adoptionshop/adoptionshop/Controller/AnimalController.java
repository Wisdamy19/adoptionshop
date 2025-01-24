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
    public ResponseEntity<AnimalEntity> getAnimalById(@PathVariable Long id) {
        Optional<AnimalEntity> getAnimalById = animalService.findById(id);
        return getAnimalById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.delete(id);
        return "Animal with ID " + id + " has been deleted";
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalEntity> updateAnimal(@PathVariable Long id, @RequestBody AnimalEntity updatedAnimal){
        Optional<AnimalEntity> existingAnimalOp = animalService.findById(id);
        if(!existingAnimalOp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        AnimalEntity existingAnimal = existingAnimalOp.get();

            existingAnimal.setType(updatedAnimal.getType());
            existingAnimal.setName(updatedAnimal.getName());
            existingAnimal.setSex(updatedAnimal.getSex());
            existingAnimal.setBreed(updatedAnimal.getBreed());
            existingAnimal.setAge(updatedAnimal.getAge());
            existingAnimal.setAdoption_fee(updatedAnimal.getAdoption_fee());
            existingAnimal.setLocation(updatedAnimal.getLocation());
            existingAnimal.setSize(updatedAnimal.getSize());
            existingAnimal.setAnimal_image(updatedAnimal.getAnimal_image());
            existingAnimal.setDescription(updatedAnimal.getDescription());
            existingAnimal.setAdopted(updatedAnimal.getAdopted());

            AnimalEntity savedAnimal = animalService.updateAnimal(existingAnimal);
            return ResponseEntity.ok(savedAnimal);
    }
}
