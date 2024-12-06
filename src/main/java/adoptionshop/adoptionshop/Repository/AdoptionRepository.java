package adoptionshop.adoptionshop.Repository;

import adoptionshop.adoptionshop.Model.Adoption_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<Adoption_entity, Integer> {
}
