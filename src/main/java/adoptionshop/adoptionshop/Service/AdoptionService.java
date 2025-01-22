package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.ENUMS.Adopted;
import adoptionshop.adoptionshop.Exceptions.AnimalAlreadyAdoptedException;
import adoptionshop.adoptionshop.Exceptions.ResourceNotFound;
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

    private final AdoptionRepository adoptionRepository;

    private final AnimalRepository animalRepository;
    @Autowired
    public AdoptionService(AdoptionRepository adoptionRepository, AnimalRepository animalRepository){
        this.adoptionRepository = adoptionRepository;
        this.animalRepository = animalRepository;
    }
    public List<AdoptionEntity> findAll(){
        return adoptionRepository.findAll();
    }

    public AdoptionEntity save(AdoptionEntity adoptionEntity) {
        return adoptionRepository.save(adoptionEntity);
    }
    public Optional<AdoptionEntity> findById(Long id){
        return adoptionRepository.findById(id);
    }
    public void delete(Long id){
        adoptionRepository.deleteById(id);
    }


}
