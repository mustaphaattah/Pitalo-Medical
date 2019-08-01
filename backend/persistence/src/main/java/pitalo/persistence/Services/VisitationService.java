package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import pitalo.domain.Patient.Patient;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Repositories.VisitationRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VisitationService implements CrudService<Visitation, Long> {
    
    private final VisitationRepository visitationRepository;

    public VisitationService(VisitationRepository visitationRepository) {
        this.visitationRepository = visitationRepository;
    }

    @Override
    public List<Visitation> findAll() {
        List<Visitation> visitations = new ArrayList<>();
        visitationRepository
            .findAll()
            .forEach(visitations::add);
        return visitations;
    }

    public List<Visitation> findAllByPatient(Patient patient) {
        List<Visitation> visitations = new ArrayList<>();
        visitationRepository
            .findVisitationsByPatient(patient)
            .forEach(visitations::add);
        return visitations;
    }

    public List<Visitation> findAllByVisitationType(String type) {
        List<Visitation> visitations = findAll()
            .stream()
            .filter(v -> v.getVisitationType().getType().equals(type))
            .collect(Collectors.toList());
        return visitations;
    }

    public boolean findByPatient(Long id, Patient patient) {
        return visitationRepository
            .findVisitationsByPatient(patient)
            .stream()
            .anyMatch(visit -> visit.getId() == id);
    }

    @Override
    public Visitation findById(Long id) {
        return visitationRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Visitation save(Visitation visitation) {
        return visitationRepository.save(visitation);
    }

    public Visitation update(Long id, Map<String, String> updates, Patient patient) {
        if (findByPatient(id, patient)) {
            Visitation visitation = findById(id);
            updates.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Visitation.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, visitation, value);
            });
            return save(visitation);
        }
        return null;
    }

    @Override
    public void delete(Visitation visitation) {
        visitationRepository.delete(visitation);
    }

    @Override
    public void deleteById(Long id) {
        visitationRepository.deleteById(id);
    }
}
