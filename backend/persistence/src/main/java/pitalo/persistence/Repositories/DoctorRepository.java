package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Staff.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
