package pitalo.web.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pitalo.domain.Staff.Nurse;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Services.NurseService;
import pitalo.persistence.Services.VisitationService;

import java.util.List;

@RestController
@RequestMapping("/api/nurses")
public class NurseController {

    private final NurseService nurseService;
    private final VisitationService visitationService;

    public NurseController(NurseService nurseService, VisitationService visitationService) {
        this.nurseService = nurseService;
        this.visitationService = visitationService;
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<?> findAll() {
        List<Nurse> nurses = nurseService.findAll();
        return new ResponseEntity<>(nurses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Nurse nurse = nurseService.findById(id);
        return new ResponseEntity<>(nurse, HttpStatus.OK);
    }

    @GetMapping("/{id}/visitations")
    public ResponseEntity<?> getVisitations(
        @PathVariable("id") Long id,
        @RequestParam(name = "type", required = false) String type,
        @RequestParam(name = "status", required = false) String status
    ) {
        Nurse nurse = nurseService.findById(id);
        List<Visitation> visitations = visitationService.findAllByNurse(nurse, type, status);
        return new ResponseEntity<>(visitations, HttpStatus.OK);
    }
}
