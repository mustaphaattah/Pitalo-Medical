package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Patient.Insurance;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Long> {
}
