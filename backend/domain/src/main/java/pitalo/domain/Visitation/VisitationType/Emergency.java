package pitalo.domain.Visitation.VisitationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@DiscriminatorValue("Emergency")
public class Emergency extends VisitationType  {

    private static final String type = "Emergency";

    @NotNull(message = "Emergency code is required")
    private EmergencyCode emergencyCode;

    @Builder
    public Emergency(Long id, Visitation visitation, String type, EmergencyCode emergencyCode) {
        super(id, visitation, Emergency.type);
        this.emergencyCode = emergencyCode;
    }
}
