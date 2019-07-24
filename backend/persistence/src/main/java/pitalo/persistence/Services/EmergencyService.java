package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Visitation.VisitationType.Emergency;
import pitalo.persistence.Repositories.EmergencyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmergencyService implements CrudService<Emergency, Long> {

    private final EmergencyRepository emergencyRepository;

    public EmergencyService(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    @Override
    public List<Emergency> findAll() {
        List<Emergency> emergencies = new ArrayList<>();
        emergencyRepository
            .findAll()
            .forEach(emergencies::add);
        return emergencies;
    }

    @Override
    public Emergency findById(Long id) {
        return emergencyRepository.findById(id).orElse(null);
    }

    @Override
    public Emergency save(Emergency emergency) {
        return emergencyRepository.save(emergency);
    }

    @Override
    public void delete(Emergency emergency) {
        emergencyRepository.delete(emergency);
    }

    @Override
    public void deleteById(Long id) {
        emergencyRepository.deleteById(id);
    }
}
