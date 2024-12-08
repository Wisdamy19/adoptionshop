package adoptionshop.adoptionshop.Repository;

import adoptionshop.adoptionshop.Model.AdoptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepository extends JpaRepository<AdoptionEntity, Integer> {
}
