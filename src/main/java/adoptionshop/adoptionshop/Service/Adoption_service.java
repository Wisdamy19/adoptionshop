package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.Model.Adoption_entity;
import adoptionshop.adoptionshop.Repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Adoption_service {
    @Autowired
    AdoptionRepository adoptionRepository;

    public List<Adoption_entity> findAll(){
        return adoptionRepository.findAll();
    }

    public Adoption_entity save(Adoption_entity adoption_entity){
        return adoptionRepository.save(adoption_entity);
    }
    public Optional<Adoption_entity> findById(int id){
        return adoptionRepository.findById(id);
    }
    public void delete(int id){
        adoptionRepository.deleteById(id);
    }
}
