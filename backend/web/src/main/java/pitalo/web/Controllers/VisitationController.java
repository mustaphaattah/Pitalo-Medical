package pitalo.web.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Services.VisitationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/visitations")
public class VisitationController {

    private VisitationService visitationService;

    public VisitationController(VisitationService visitationService) {
        this.visitationService = visitationService;
    }


    @GetMapping({ "/", ""})
    public ResponseEntity<?> findAll(@RequestParam(name = "type", required = false) String type) {

        if (type != null) {
            List<Visitation> visitations = visitationService.findAllByVisitationType(type);
            return new ResponseEntity<>(visitations, HttpStatus.OK);
        }

        List<Visitation> visitations = visitationService.findAll();
        return new ResponseEntity<>(visitations, HttpStatus.OK);
}

    @PostMapping({ "/", ""})
    public ResponseEntity<?> createVisitation(@Valid @RequestBody Visitation visitation, BindingResult result) {
        Visitation savedVisitation = visitationService.save(visitation);
        return new ResponseEntity<>(savedVisitation, HttpStatus.OK);
    }
}
