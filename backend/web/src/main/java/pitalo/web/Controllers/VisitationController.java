package pitalo.web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pitalo.domain.Patient.Patient;
import pitalo.domain.Staff.Doctor;
import pitalo.domain.Staff.Nurse;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Services.DoctorService;
import pitalo.persistence.Services.NurseService;
import pitalo.persistence.Services.PatientService;
import pitalo.persistence.Services.VisitationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/visitations")
public class VisitationController {

    @Autowired
    private VisitationService visitationService;

    @Autowired
    private NurseService nurseService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @PostMapping({ "/", ""})
    public ResponseEntity<?> createVisitation(
        @Valid @RequestBody Visitation visitation,
        @RequestParam("patientId") Long patientId,
        @RequestParam("nurseId") Long nurseId,
        @RequestParam("doctorId") Long doctorId
    ) {
        Patient patient = patientService.findById(patientId);
        Nurse nurse = nurseService.findById(nurseId);
        Doctor doctor = doctorService.findById(doctorId);

        visitation.setDoctor(doctor);
        visitation.setNurse(nurse);
        visitation.setPatient(patient);

        Visitation savedVisitation = visitationService.save(visitation);
        return new ResponseEntity<>(savedVisitation, HttpStatus.OK);
    }
}
