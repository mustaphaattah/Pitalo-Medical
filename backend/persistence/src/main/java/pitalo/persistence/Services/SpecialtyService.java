package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Staff.Specialty;
import pitalo.persistence.Repositories.SpecialtyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialtyService implements CrudService<Specialty, Long> {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public List<Specialty> findAll() {
        List<Specialty> specialties = new ArrayList<>();

        specialtyRepository
            .findAll()
            .forEach(specialties::add);

        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
