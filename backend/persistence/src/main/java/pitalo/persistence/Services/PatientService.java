package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Patient.Patient;
import pitalo.persistence.Exceptions.PatientNotFoundException;
import pitalo.persistence.Repositories.PatientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements CrudService<Patient, Long> {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        patientRepository
            .findAll()
            .forEach(patients::add);
        return patients;
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id)
            .orElseThrow(() -> new PatientNotFoundException(String.format("Patient with id: '%s' does not exist", id)));
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
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
