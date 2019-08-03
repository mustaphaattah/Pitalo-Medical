package pitalo.web.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Services.VisitationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/visitations")
public class VisitationController {

    private VisitationService visitationService;

    public VisitationController(VisitationService visitationService) {
        this.visitationService = visitationService;
    }

    @PostMapping({ "/", ""})
    public ResponseEntity<?> createVisitation(@Valid @RequestBody Visitation visitation) {
        Visitation savedVisitation = visitationService.save(visitation);
        return new ResponseEntity<>(savedVisitation, HttpStatus.OK);
    }
}
