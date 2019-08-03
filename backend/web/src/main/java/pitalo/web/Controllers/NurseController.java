package pitalo.web.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pitalo.domain.Staff.Nurse;
import pitalo.persistence.Services.NurseService;

import java.util.List;

@RestController
@RequestMapping("/api/nurses")
public class NurseController {

    private final NurseService nurseService;

    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
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
}
