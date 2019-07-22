package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Patient.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
