package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.Model.Medical_notes;
import adoptionshop.adoptionshop.Repository.MedicalNotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Medical_notes_service {
    @Autowired
    MedicalNotesRepository medicalNotesRepository;

    public List<Medical_notes> findAll(){
        return medicalNotesRepository.findAll();
    }

    public Medical_notes save(Medical_notes medical_notes){
        return medicalNotesRepository.save(medical_notes);
    }

    public Optional<Medical_notes> findById(int id){
        return medicalNotesRepository.findById(id);
    }

    public void delete(int id){
        medicalNotesRepository.deleteById(id);
    }
}
