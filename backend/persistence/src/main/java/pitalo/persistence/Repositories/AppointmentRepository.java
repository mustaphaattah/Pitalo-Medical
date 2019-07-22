package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Visitation.VisitationType.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
