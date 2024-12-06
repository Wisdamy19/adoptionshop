package adoptionshop.adoptionshop.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "adoption_table")
public class Adoption_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adoption_id")
    private int id;

    @Column(name = "adoption_date", nullable = false)
    private LocalDateTime adoption_date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer_entity customer_entity;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal_entity animal_entity;


}
