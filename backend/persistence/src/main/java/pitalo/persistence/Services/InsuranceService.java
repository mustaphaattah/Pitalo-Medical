package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Patient.Insurance;
import pitalo.persistence.Repositories.InsuranceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceService implements CrudService<Insurance, Long> {

    private final InsuranceRepository insuranceRepository;

    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public List<Insurance> findAll() {
        List<Insurance> insurances = new ArrayList<>();
        insuranceRepository
            .findAll()
            .forEach(insurances::add);
        return insurances;
    }

    @Override
    public Insurance findById(Long id) {
        return insuranceRepository.findById(id).orElse(null);
    }

    @Override
    public Insurance save(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @Override
    public void delete(Insurance insurance) {
        insuranceRepository.delete(insurance);
    }

    @Override
    public void deleteById(Long id) {
        insuranceRepository.deleteById(id);
    }
}
