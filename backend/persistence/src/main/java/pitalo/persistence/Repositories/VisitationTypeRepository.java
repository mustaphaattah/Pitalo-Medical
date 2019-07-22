package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitationTypeRepository extends CrudRepository<VisitationTypeRepository, Long> {
}
