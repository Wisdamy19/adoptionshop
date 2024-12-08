package adoptionshop.adoptionshop.Service;

import adoptionshop.adoptionshop.Model.MedicalNotesEntity;
import adoptionshop.adoptionshop.Repository.MedicalNotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MedicalNoteService {
    @Autowired
    MedicalNotesRepository medicalNotesRepository;

    public List<MedicalNotesEntity> findAll(){
        return medicalNotesRepository.findAll();
    }

    public MedicalNotesEntity save(MedicalNotesEntity medicalNotesEntity){
        return medicalNotesRepository.save(medicalNotesEntity);
    }

    public Optional<MedicalNotesEntity> findById(int id){
        return medicalNotesRepository.findById(id);
    }

    public void delete(int id){
        medicalNotesRepository.deleteById(id);
    }
}
