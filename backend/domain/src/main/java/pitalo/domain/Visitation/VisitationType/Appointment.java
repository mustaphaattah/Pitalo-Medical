package pitalo.domain.Visitation.VisitationType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Appointment")
public class Appointment extends VisitationType  {

    private static final String type = "Appointment";

    @Builder
    public Appointment(Long id, Visitation visitation, String type) {
        super(id, visitation, Appointment.type);
    }
}
