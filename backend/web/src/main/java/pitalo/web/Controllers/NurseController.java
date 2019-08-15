package pitalo.web.Controllers;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(
        value = "Find all nurses",
        notes = "Retrieve a collection of all nurses",
        response = Nurse[].class
    )
    @GetMapping({ "", "/" })
    public ResponseEntity<?> findAll() {
        List<Nurse> nurses = nurseService.findAll();
        return new ResponseEntity<>(nurses, HttpStatus.OK);
    }

    @ApiOperation(
        value = "Find one nurse",
        notes = "Retrieve a nurse by id",
        response = Nurse.class
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Nurse nurse = nurseService.findById(id);
        return new ResponseEntity<>(nurse, HttpStatus.OK);
    }

    @ApiOperation(
        value = "Find all visitations by a nurse",
        notes = "Retrieve all visitations by a nurse, can be filtered by type and status",
        response = Visitation[].class
    )
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
