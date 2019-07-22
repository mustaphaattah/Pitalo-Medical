package pitalo.domain.Visitation.VisitationType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@SuperBuilder
public class WalkIn extends BaseEntity implements VisitationType {

    private static final String name = "WalkIn";
}
