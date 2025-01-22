package adoptionshop.adoptionshop.Model;

import adoptionshop.adoptionshop.ENUMS.Adopted;
import adoptionshop.adoptionshop.ENUMS.Sex;
import adoptionshop.adoptionshop.ENUMS.Size;
import adoptionshop.adoptionshop.ENUMS.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "animal_table")
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Long id;

    @Enumerated
    @Column(columnDefinition = "ENUM('DOG', 'CAT')")
    private Type type;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('MALE', 'FEMALE')")
    private Sex sex;

    @Column(name = "breed")
    private String breed;

    @Column(name = "age")
    private LocalDate age;

    @Column(name = "adoption_fee")
    private double adoption_fee;

    @Column(name = "location")
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('SMALL', 'MEDIUM', 'LARGE')")
    private Size size;

    @Lob
    @Column(name = "animal_image", nullable = true)
    private byte[] animal_image;

    @Lob
    @Column(name = "description", nullable = true)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('YES', 'NO')")
    private Adopted adopted;

    @OneToMany(mappedBy = "animalEntity")
    @JsonIgnore
    private List<AdoptionEntity> adoptions;

    @OneToOne(mappedBy = "animalEntity")
    @JsonIgnore
    private MedicalNotesEntity medicalNotesEntity;



}
