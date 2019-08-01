package pitalo.domain.Visitation.VisitationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Appointment")
public class Appointment extends VisitationType  {

    private static final String type = "Appointment";

    @NotNull(message = "Appointment Status is required")
    private AppointmentStatus appointmentStatus;

    @Builder

    public Appointment(Long id, Visitation visitation, String type, @NotNull(message = "Appointment Status is required") AppointmentStatus appointmentStatus) {
        super(id, visitation, Appointment.type);
        this.appointmentStatus = appointmentStatus;
    }
}
