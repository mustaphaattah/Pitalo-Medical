package pitalo.domain.Visitation.VisitationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@SuperBuilder
@AllArgsConstructor
public class Emergency extends BaseEntity implements VisitationType  {

    private static final String name = "Emergency";

    private EmergencyCode emergencyCode;
}
