package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Staff.Nurse;

@Repository
public interface NurseRepository extends CrudRepository<Nurse, Long> {
}
