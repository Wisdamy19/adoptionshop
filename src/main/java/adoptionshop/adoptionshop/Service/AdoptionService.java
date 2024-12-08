package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.Model.AdoptionEntity;
import adoptionshop.adoptionshop.Model.AnimalEntity;
import adoptionshop.adoptionshop.Repository.AdoptionRepository;
import adoptionshop.adoptionshop.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdoptionService {
    @Autowired
    AdoptionRepository adoptionRepository;
    @Autowired
    AnimalRepository animalRepository;
    AnimalEntity animalEntity;
    public List<AdoptionEntity> findAll(){
        return adoptionRepository.findAll();
    }

    public AdoptionEntity save(AdoptionEntity adoptionEntity){
        return adoptionRepository.save(adoptionEntity);
    }
    public Optional<AdoptionEntity> findById(int id){
        return adoptionRepository.findById(id);
    }
    public void delete(int id){
        adoptionRepository.deleteById(id);
    }
}
