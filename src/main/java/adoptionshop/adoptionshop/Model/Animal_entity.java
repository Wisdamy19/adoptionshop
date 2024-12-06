package adoptionshop.adoptionshop.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "animal_table")
public class Animal_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

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

    @OneToMany(mappedBy = "animal_entity")
    @JsonIgnore
    private List<Adoption_entity> adoption_entityList;

    @OneToOne(mappedBy = "animal_entity")
    @JsonIgnore
    private Medical_notes medical_notes;



}
