package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.Model.AnimalEntity;
import adoptionshop.adoptionshop.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<AnimalEntity> findAll(){
        return animalRepository.findAll();
    }
    public AnimalEntity save(AnimalEntity animalEntity){
        return animalRepository.save(animalEntity);

    }
    public Optional<AnimalEntity> findById(int id) {
        return animalRepository.findById(id);
    }
    public void delete(int id) {
        animalRepository.deleteById(id);
    }

}
