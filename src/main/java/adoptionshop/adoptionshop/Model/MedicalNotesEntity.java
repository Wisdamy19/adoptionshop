package adoptionshop.adoptionshop.Model;

import adoptionshop.adoptionshop.ENUMS.Desexed;
import adoptionshop.adoptionshop.ENUMS.Vaccinated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "medical_notes")
public class MedicalNotesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_id")
    private int id;

    @Column(name = "medical_date")
    private LocalDateTime medical_date;

    @OneToOne
    @JoinColumn(name = "animal_id")
    private AnimalEntity animalEntity;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('YES', 'NO')")
    private Desexed desexed;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('YES', 'NO')")
    private Vaccinated vaccinated;







}
