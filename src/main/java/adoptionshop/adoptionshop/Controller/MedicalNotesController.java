package adoptionshop.adoptionshop.Controller;

import adoptionshop.adoptionshop.Model.Medical_notes;
import adoptionshop.adoptionshop.Service.Medical_notes_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicalnotes")
public class MedicalNotesController {
    @Autowired
    Medical_notes_service medical_notes_service;

    @PostMapping
    public Medical_notes createMedicalNotes(@RequestBody Medical_notes medical_notes){
        return medical_notes_service.save(medical_notes);
    }
    @GetMapping()
    public List<Medical_notes> getAllMedicalNotes(){
        return medical_notes_service.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Medical_notes> getMedicalNotesById(@PathVariable int id){
        return medical_notes_service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteMedicalNotes(@PathVariable int id){
        medical_notes_service.delete(id);
        return "Medical Notes with Id " + id + " has been deleted";
    }

}
