package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Patient.EmergencyContact;
import pitalo.persistence.Repositories.EmergencyContactRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmergencyContactService implements CrudService<EmergencyContact, Long> {

    private final EmergencyContactRepository emergencyContactRepository;

    public EmergencyContactService(EmergencyContactRepository emergencyContactRepository) {
        this.emergencyContactRepository = emergencyContactRepository;
    }

    @Override
    public List<EmergencyContact> findAll() {
        List<EmergencyContact> contacts = new ArrayList<>();
        emergencyContactRepository
            .findAll()
            .forEach(contacts::add);
        return contacts;
    }

    @Override
    public EmergencyContact findById(Long id) {
        return emergencyContactRepository.findById(id).orElse(null);
    }

    @Override
    public EmergencyContact save(EmergencyContact emergencyContact) {
        return emergencyContactRepository.save(emergencyContact);
    }

    @Override
    public void delete(EmergencyContact emergencyContact) {
        emergencyContactRepository.delete(emergencyContact);
    }

    @Override
    public void deleteById(Long id) {
        emergencyContactRepository.deleteById(id);
    }
}
