package adoptionshop.adoptionshop.Repository;

import adoptionshop.adoptionshop.Model.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {

}
