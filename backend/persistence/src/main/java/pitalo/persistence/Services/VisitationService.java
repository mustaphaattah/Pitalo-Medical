package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import pitalo.domain.Patient.Patient;
import pitalo.domain.Staff.Doctor;
import pitalo.domain.Staff.Nurse;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Exceptions.VisitationNotFoundException;
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

    public List<Visitation> findAllByPatient(Patient patient, String type, String status) {
        List<Visitation> visitations = visitationRepository
            .findVisitationsByPatient(patient);

        if (type != null) {
            visitations = visitations
                .stream()
                .filter(visit -> visit.getVisitationType().getType().equals(type))
                .collect(Collectors.toList());

            if (status != null) {
                return visitations
                    .stream()
                    .filter(visit -> visit.getStatus().name().equals(status))
                    .collect(Collectors.toList());
            }
        }

        return visitations;
    }

    public List<Visitation> findAllByNurse(Nurse nurse, String type, String status) {
        List<Visitation> visitations = visitationRepository
            .findVisitationsByNurse(nurse)
            .stream()
            .collect(Collectors.toList());

        if (type != null) {
            visitations = visitations
                .stream()
                .filter(visit -> visit.getVisitationType().getType().equals(type))
                .collect(Collectors.toList());

            if (status != null) {
                return visitations
                    .stream()
                    .filter(visit -> visit.getStatus().name().equals(status))
                    .collect(Collectors.toList());
            }
        }

        return visitations;
    }

    public List<Visitation> findAllByDoctor(Doctor doctor, String type, String status) {
        List<Visitation> visitations = visitationRepository
            .findVisitationsByDoctor(doctor)
            .stream()
            .collect(Collectors.toList());

        if (type != null) {
            visitations = visitations
                .stream()
                .filter(visit -> visit.getVisitationType().getType().equals(type))
                .collect(Collectors.toList());

            if (status != null) {
                return visitations
                    .stream()
                    .filter(visit -> visit.getStatus().name().equals(status))
                    .collect(Collectors.toList());
            }
        }

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
        return visitationRepository.findById(id).orElseThrow(
            () -> new VisitationNotFoundException(String.format("Visitation with id: '%s' does not exist", id)));
    }

    @Override
    public Visitation save(Visitation visitation) {
        return visitationRepository.save(visitation);
    }

    public Visitation update(Long id, Map<String, Object> updates, Patient patient) {
        boolean patientHasVisitation = findByPatient(id, patient);
        if (patientHasVisitation) {
            Visitation visitation = findById(id);
            updates.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Visitation.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, visitation, value);
            });
            return save(visitation);
        }
        throw new VisitationNotFoundException(
            String.format("Patient with id: '%s' has no visitation with id: '%s'", patient.getId(), id)
        );
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
