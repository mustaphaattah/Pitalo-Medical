package pitalo.domain.Visitation.VisitationType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@Builder
public class Emergency implements VisitationType  {

    private static final String name = "Emergency";

    private EmergencyCode emergencyCode;
}
