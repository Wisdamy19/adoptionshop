package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.Model.AnimalEntity;
import adoptionshop.adoptionshop.Repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    @Autowired
    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public List<AnimalEntity> findAll(){
        return animalRepository.findAll();
    }
    public AnimalEntity save(AnimalEntity animalEntity){
        return animalRepository.save(animalEntity);

    }
    public Optional<AnimalEntity> findById(Long id) {
        return animalRepository.findById(id);
    }
    public void delete(Long id) {
        animalRepository.deleteById(id);
    }
    public AnimalEntity updateAnimal(AnimalEntity animalEntity){
        if (animalEntity == null || animalEntity.getId() == null){
            throw new IllegalArgumentException("Invalid.");
        }
        if (!animalRepository.existsById(animalEntity.getId())){
            throw new EntityNotFoundException("Animal with ID " + animalEntity.getId() + " not found.");
        }
        return animalRepository.save(animalEntity);
    }

}
