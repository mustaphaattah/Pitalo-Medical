package pitalo.web.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pitalo.domain.Staff.Doctor;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Services.DoctorService;
import pitalo.persistence.Services.VisitationService;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final VisitationService visitationService;

    public DoctorController(DoctorService doctorService, VisitationService visitationService) {
        this.doctorService = doctorService;
        this.visitationService = visitationService;
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<?> findAll() {
        List<Doctor> doctors = doctorService.findAll();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Doctor doctor = doctorService.findById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @GetMapping("/{id}/visitations")
    public ResponseEntity<?> getVisitations(
        @PathVariable("id") Long id,
        @RequestParam(name = "type", required = false) String type,
        @RequestParam(name = "status", required = false) String status
    ) {
        Doctor doctor = doctorService.findById(id);
        List<Visitation> visitations = visitationService.findAllByDoctor(doctor, type, status);
        return new ResponseEntity<>(visitations, HttpStatus.OK);
    }

}
