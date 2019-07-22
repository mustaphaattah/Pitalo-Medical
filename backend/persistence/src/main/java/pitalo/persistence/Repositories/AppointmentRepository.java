package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import pitalo.domain.Visitation.VisitationType.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
