package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Visitation.Vitals;

@Repository
public interface VitalsRepository extends CrudRepository<Vitals, Long> {
}
