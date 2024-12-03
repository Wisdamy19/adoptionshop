package adoptionshop.adoptionshop.Repository;

import adoptionshop.adoptionshop.Model.Animal_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal_entity, Integer> {

}
