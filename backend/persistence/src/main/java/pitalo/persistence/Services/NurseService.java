package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Staff.Nurse;
import pitalo.persistence.Exceptions.NurseNotFoundException;
import pitalo.persistence.Repositories.NurseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService implements CrudService<Nurse, Long> {

    private final NurseRepository nurseRepository;

    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    @Override
    public List<Nurse> findAll() {
        List<Nurse> nurses = new ArrayList<>();
        nurseRepository
            .findAll()
            .forEach(nurses::add);
        return nurses;
    }

    @Override
    public Nurse findById(Long id) {
        return nurseRepository.findById(id)
            .orElseThrow(() -> new NurseNotFoundException(String.format("Nurse with id: %s does not exist", id)));
    }

    @Override
    public Nurse save(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    @Override
    public void delete(Nurse nurse) {
        nurseRepository.delete(nurse);
    }

    @Override
    public void deleteById(Long id) {
        nurseRepository.deleteById(id);
    }
}
