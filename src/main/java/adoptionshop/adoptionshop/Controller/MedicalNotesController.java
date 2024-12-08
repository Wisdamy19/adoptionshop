package adoptionshop.adoptionshop.Controller;

import adoptionshop.adoptionshop.Model.MedicalNotesEntity;
import adoptionshop.adoptionshop.Service.MedicalNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicalnotes")
public class MedicalNotesController {
    @Autowired
    MedicalNoteService medicalNoteService;

    @PostMapping
    public ResponseEntity<MedicalNotesEntity> createMedicalNotes(@RequestBody MedicalNotesEntity medicalNotesEntity){
        MedicalNotesEntity savedMedicalNotes = medicalNoteService.save(medicalNotesEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedicalNotes);
    }
    @GetMapping()
    public ResponseEntity<List<MedicalNotesEntity>> getAllMedicalNotes(){
        List<MedicalNotesEntity> getAllMedicalNotes = medicalNoteService.findAll();
        if (getAllMedicalNotes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(getAllMedicalNotes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MedicalNotesEntity> getMedicalNotesById(@PathVariable int id){
        Optional<MedicalNotesEntity> getMedicalNotesById = medicalNoteService.findById(id);
        return getMedicalNotesById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicalNotes(@PathVariable int id){
        medicalNoteService.delete(id);
        return ResponseEntity.ok("Medical Notes with Id " + id + " has been deleted");
    }

}
