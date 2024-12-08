package adoptionshop.adoptionshop.Repository;

import adoptionshop.adoptionshop.Model.MedicalNotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalNotesRepository extends JpaRepository<MedicalNotesEntity, Integer> {
}
