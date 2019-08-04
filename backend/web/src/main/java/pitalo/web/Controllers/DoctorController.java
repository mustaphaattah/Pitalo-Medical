package pitalo.web.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final VisitationService visitationService;

    public DoctorController(DoctorService doctorService, VisitationService visitationService) {
        this.doctorService = doctorService;
        this.visitationService = visitationService;
    }

    @ApiOperation(
        value = "Find all doctors",
        notes = "Retrieving a collection of all the doctors",
        response = Doctor[].class
    )
    @GetMapping({ "", "/" })
    public ResponseEntity<?> findAll() {
        List<Doctor> doctors = doctorService.findAll();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @ApiOperation(
        value = "Find one doctor",
        notes = "Retrieve a doctor by id",
        response = Doctor.class
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Doctor doctor = doctorService.findById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @ApiOperation(
        value = "Find all visitations by a doctor",
        notes = "Retrieve all visitations by a doctor, can be filtered by type and status",
        response = Visitation[].class
    )
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
