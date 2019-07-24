package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Patient.MedicalHistory;
import pitalo.persistence.Repositories.MedicalHistoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalHistoryService implements CrudService<MedicalHistory, Long> {

    private final MedicalHistoryRepository medicalHistoryRepository;

    public MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    @Override
    public List<MedicalHistory> findAll() {
        List<MedicalHistory> medicalHistories = new ArrayList<>();
        medicalHistoryRepository
            .findAll()
            .forEach(medicalHistories::add);
        return medicalHistories;
    }

    @Override
    public MedicalHistory findById(Long id) {
        return medicalHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public MedicalHistory save(MedicalHistory history) {
        return medicalHistoryRepository.save(history);
    }

    @Override
    public void delete(MedicalHistory history) {
        medicalHistoryRepository.delete(history);
    }

    @Override
    public void deleteById(Long id) {
        medicalHistoryRepository.deleteById(id);
    }
}
