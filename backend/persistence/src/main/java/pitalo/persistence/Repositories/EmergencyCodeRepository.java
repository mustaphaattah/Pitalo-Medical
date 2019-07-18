package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.EmergencyCode;

@Repository
public interface EmergencyCodeRepository extends CrudRepository<EmergencyCode, String> {
}
