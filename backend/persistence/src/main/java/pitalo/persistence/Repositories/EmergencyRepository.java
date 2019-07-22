package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Visitation.VisitationType.Emergency;

@Repository
public interface EmergencyRepository extends CrudRepository<Emergency, Long> {
}
