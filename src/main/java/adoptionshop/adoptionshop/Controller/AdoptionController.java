package adoptionshop.adoptionshop.Controller;

import adoptionshop.adoptionshop.Model.AdoptionEntity;
import adoptionshop.adoptionshop.Service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adoptions")
public class AdoptionController {
    @Autowired
    AdoptionService adoptionService;

    @PostMapping
    public ResponseEntity<AdoptionEntity> createAdoption(@RequestBody AdoptionEntity adoptionEntity){
        AdoptionEntity savedAdoption = adoptionService.save(adoptionEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdoption);

    }

    @GetMapping
    public ResponseEntity<List<AdoptionEntity>> getAllAdoptions(){
        List<AdoptionEntity> getAllAdoptions = adoptionService.findAll();
        if (getAllAdoptions.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(getAllAdoptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptionEntity> getAdoptionById(@PathVariable Long id){
        Optional<AdoptionEntity> getAdoptionById = adoptionService.findById(id);
        return getAdoptionById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdoption (@PathVariable Long id){
        adoptionService.delete(id);
        return ResponseEntity.ok( + id + " has been deleted");

    }
}
