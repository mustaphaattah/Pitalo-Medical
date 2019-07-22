package pitalo.domain.Visitation.VisitationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Appointment extends BaseEntity implements VisitationType  {

    private static final String name = "Appointment";

    private AppointmentStatus appointmentStatus;
}
