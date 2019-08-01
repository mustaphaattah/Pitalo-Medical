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
    public ResponseEntity<?> findAll() {
        List<Patient> patients = patientService.findAll();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping({ "", "/"})
    public ResponseEntity<?> registerPatient(@Valid @RequestBody Patient patient) {
        Patient savedPatient = patientService.save(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePatient(
        @Valid @RequestBody Patient patient,
        @PathVariable("id") Long id
    ) {
        Patient savedPatient = patientService.save(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
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
        if (visitation == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(visitation, HttpStatus.OK);
    }

}
