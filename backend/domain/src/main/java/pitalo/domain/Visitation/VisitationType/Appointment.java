package pitalo.domain.Visitation.VisitationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends VisitationType  {

    @NotNull(message = "Appointment Status is required")
    private AppointmentStatus appointmentStatus;

    @Builder
    public Appointment(Long id, Visitation visitation, AppointmentStatus appointmentStatus) {
        super(id, visitation);
        this.appointmentStatus = appointmentStatus;
    }

}
