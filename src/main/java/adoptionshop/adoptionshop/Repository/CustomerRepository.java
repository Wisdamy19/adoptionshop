package adoptionshop.adoptionshop.Repository;

import adoptionshop.adoptionshop.Model.Customer_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer_entity, Integer> {
}
