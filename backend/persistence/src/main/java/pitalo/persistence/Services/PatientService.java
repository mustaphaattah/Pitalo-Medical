package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import pitalo.domain.Patient.Patient;
import pitalo.persistence.Exceptions.PatientNotFoundException;
import pitalo.persistence.Repositories.PatientRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PatientService implements CrudService<Patient, Long> {

    private final PatientRepository patientRepository;
    private final EmergencyContactService emergencyContactService;

    public PatientService(PatientRepository patientRepository, EmergencyContactService emergencyContactService) {
        this.patientRepository = patientRepository;
        this.emergencyContactService = emergencyContactService;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        patientRepository
            .findAll()
            .forEach(patients::add);
        return patients;
    }

    public List<Patient> findAll(String searchBy, String value) {
        switch (searchBy) {
            case "firstName":
                return patientRepository
                    .findAllByFirstNameLike(String.format("%%%s%%", value));

            default:
                return new ArrayList<>();
        }
    }



    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id)
            .orElseThrow(() -> new PatientNotFoundException(String.format("Patient with id: '%s' does not exist", id)));
    }

    @Override
    public Patient save(Patient patient) {
        Patient savedPatient = patientRepository.save(patient);

        if (savedPatient.getEmergencyContacts() != null) {
            savedPatient
                .getEmergencyContacts()
                .forEach(contact -> {
                    contact.setPatient(savedPatient);
                    emergencyContactService.save(contact);
                });
        }
        return savedPatient;
    }

    public Patient update(Long id, Map<String, Object> updates) {
        Patient patient = findById(id);
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Patient.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, patient, value);
        });
        return save(patient);
    }

    @Override
    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

}
