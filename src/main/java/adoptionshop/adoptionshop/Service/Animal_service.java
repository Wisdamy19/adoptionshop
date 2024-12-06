package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.Model.Animal_entity;
import adoptionshop.adoptionshop.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Animal_service {
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal_entity> findAll(){
        return animalRepository.findAll();
    }
    public Animal_entity save(Animal_entity animal_entity){
        return animalRepository.save(animal_entity);

    }
    public Optional<Animal_entity> findById(int id) {
        return animalRepository.findById(id);
    }
    public void delete(int id) {
        animalRepository.deleteById(id);
    }

}
