package pitalo.domain.Visitation.VisitationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment implements VisitationType {

    private static final String name = "Appointment";

    private AppointmentStatus appointmentStatus;
}
