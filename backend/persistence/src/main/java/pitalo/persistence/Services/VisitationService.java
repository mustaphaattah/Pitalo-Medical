package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Repositories.VisitationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitationService implements CrudService<Visitation, Long> {
    
    private final VisitationRepository visitationRepository;

    public VisitationService(VisitationRepository visitationRepository) {
        this.visitationRepository = visitationRepository;
    }

    @Override
    public List<Visitation> findAll() {
        List<Visitation> visitations = new ArrayList<>();
        visitationRepository
            .findAll()
            .forEach(visitations::add);
        return visitations;
    }

    @Override
    public Visitation findById(Long id) {
        return visitationRepository.findById(id).orElse(null);
    }

    @Override
    public Visitation save(Visitation visitation) {
        return visitationRepository.save(visitation);
    }

    @Override
    public void delete(Visitation visitation) {
        visitationRepository.delete(visitation);
    }

    @Override
    public void deleteById(Long id) {
        visitationRepository.deleteById(id);
    }
}
