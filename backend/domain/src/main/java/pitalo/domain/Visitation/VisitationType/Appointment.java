package pitalo.domain.Visitation.VisitationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends BaseEntity implements VisitationType  {

    private AppointmentStatus appointmentStatus;

    @Builder
    public Appointment(Long id, AppointmentStatus appointmentStatus) {
        super(id);
        this.appointmentStatus = appointmentStatus;
    }
}
