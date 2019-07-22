package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Patient.MedicalHistory;

@Repository
public interface MedicalHistoryRepository extends CrudRepository<MedicalHistory, Long> {
}
