package pitalo.domain.Visitation.VisitationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Emergency extends VisitationType  {

    @NotNull(message = "Emergency code is required")
    private EmergencyCode emergencyCode;

    @Builder
    public Emergency(Long id, Visitation visitation, EmergencyCode emergencyCode) {
        super(id, visitation);
        this.emergencyCode = emergencyCode;
    }
}
