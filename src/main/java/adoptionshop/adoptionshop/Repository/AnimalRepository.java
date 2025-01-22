package adoptionshop.adoptionshop.Repository;

import adoptionshop.adoptionshop.Model.AnimalEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE AnimalEntity a SET a.adopted = 'YES' WHERE a.id = :id")
    void updateAdoptedStatus(@Param("id") Long id);


}
