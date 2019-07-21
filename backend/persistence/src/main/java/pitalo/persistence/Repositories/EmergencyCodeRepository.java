package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Visitation.VisitationType.EmergencyCode;

@Repository
public interface EmergencyCodeRepository extends CrudRepository<EmergencyCode, String> {
}
