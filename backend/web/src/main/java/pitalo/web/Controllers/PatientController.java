package pitalo.web.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pitalo.domain.Patient.Patient;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Services.PatientService;
import pitalo.persistence.Services.VisitationService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;
    private final VisitationService visitationService;

    public PatientController(PatientService patientService, VisitationService visitationService) {
        this.patientService = patientService;
        this.visitationService = visitationService;
    }

    @GetMapping({ "", "/"})
    public ResponseEntity<?> findAll(
        @RequestParam(name = "searchBy", required = false) String searchBy,
        @RequestParam(name = "value", required = false) String value
    ) {
        if (searchBy == null && value == null) {
            List<Patient> patients = patientService.findAll();
            return new ResponseEntity<>(patients, HttpStatus.OK);
        }
        List<Patient> patients = patientService.findAll(searchBy, value);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping({ "", "/"})
    public ResponseEntity<?> registerPatient(@Valid @RequestBody Patient patient) {
        Patient savedPatient = patientService.save(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePatient(
        @RequestBody Map<String, Object> updates,
        @PathVariable("id") Long id
    ) {
        Patient updatedPatient = patientService.update(id, updates);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
        Patient patient = patientService.findById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("/{id}/visitations")
    public ResponseEntity<?> getVisitations(@PathVariable("id") Long id) {
        Patient patient = patientService.findById(id);
        List<Visitation> visitations = visitationService.findAllByPatient(patient);
        return new ResponseEntity<>(visitations, HttpStatus.OK);
    }

    @PatchMapping ("/{id}/visitations/{visitationId}")
    public ResponseEntity<?> updateVisitation(
        @PathVariable("id") Long id,
        @PathVariable("visitationId") Long visitationId,
        @RequestBody Map<String, String> updates
    ) {
        Patient patient = patientService.findById(id);
        Visitation visitation = visitationService.update(visitationId, updates, patient);
        return new ResponseEntity<>(visitation, HttpStatus.OK);
    }

}
