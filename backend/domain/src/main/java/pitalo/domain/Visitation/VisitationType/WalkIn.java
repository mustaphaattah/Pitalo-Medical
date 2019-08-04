package pitalo.domain.Visitation.VisitationType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("WalkIn")
public class WalkIn extends VisitationType {

    private static final String type = "WalkIn";

    @Builder
    public WalkIn(Long id, Visitation visitation, String type) {
        super(id, visitation, WalkIn.type);
    }
}
