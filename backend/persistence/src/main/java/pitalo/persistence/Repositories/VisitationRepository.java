package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Visitation.Visitation;

@Repository
public interface VisitationRepository extends CrudRepository<Visitation, Long> {
}
