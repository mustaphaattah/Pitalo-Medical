package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Patient.EmergencyContact;

@Repository
public interface EmergencyContactRepository extends CrudRepository<EmergencyContact, Long> {
}
