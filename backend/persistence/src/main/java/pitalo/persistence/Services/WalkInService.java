package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Visitation.VisitationType.WalkIn;
import pitalo.persistence.Repositories.WalkInRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalkInService implements CrudService<WalkIn, Long> {

    private final WalkInRepository walkInRepository;

    public WalkInService(WalkInRepository walkInRepository) {
        this.walkInRepository = walkInRepository;
    }

    @Override
    public List<WalkIn> findAll() {
        List<WalkIn> walkIns = new ArrayList<>();
        walkInRepository
            .findAll()
            .forEach(walkIns::add);

        return walkIns;
    }

    @Override
    public WalkIn findById(Long id) {
        return walkInRepository.findById(id).orElse(null);
    }

    @Override
    public WalkIn save(WalkIn walkIn) {
        return walkInRepository.save(walkIn);
    }

    @Override
    public void delete(WalkIn walkIn) {
        walkInRepository.delete(walkIn);
    }

    @Override
    public void deleteById(Long id) {
        walkInRepository.deleteById(id);
    }
}
