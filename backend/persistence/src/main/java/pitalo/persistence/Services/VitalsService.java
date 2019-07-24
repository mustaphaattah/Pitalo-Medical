package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Visitation.Vitals;
import pitalo.persistence.Repositories.VitalsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VitalsService implements CrudService<Vitals, Long> {

    private final VitalsRepository vitalsRepository;

    public VitalsService(VitalsRepository vitalsRepository) {
        this.vitalsRepository = vitalsRepository;
    }

    @Override
    public List<Vitals> findAll() {
        List<Vitals> vitalsList = new ArrayList<>();
        vitalsRepository
            .findAll()
            .forEach(vitalsList::add);

        return vitalsList;
    }

    @Override
    public Vitals findById(Long id) {
        return vitalsRepository.findById(id).orElse(null);
    }

    @Override
    public Vitals save(Vitals vitals) {
        return vitalsRepository.save(vitals);
    }

    @Override
    public void delete(Vitals vitals) {
        vitalsRepository.delete(vitals);
    }

    @Override
    public void deleteById(Long id) {
        vitalsRepository.deleteById(id);
    }
}
