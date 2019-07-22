package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Visitation.VisitationType.WalkIn;

@Repository
public interface WalkInRepository extends CrudRepository<WalkIn, Long> {
}
