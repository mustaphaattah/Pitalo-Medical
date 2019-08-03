package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Patient.Patient;
import pitalo.domain.Staff.Doctor;
import pitalo.domain.Staff.Nurse;
import pitalo.domain.Visitation.Visitation;

import java.util.List;

@Repository
public interface VisitationRepository extends CrudRepository<Visitation, Long> {

    List<Visitation> findVisitationsByPatient(Patient patient);
    List<Visitation> findVisitationsByNurse(Nurse nurse);
    List<Visitation> findVisitationsByDoctor(Doctor doctor);
}
