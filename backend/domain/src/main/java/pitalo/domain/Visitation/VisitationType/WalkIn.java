package pitalo.domain.Visitation.VisitationType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class WalkIn extends VisitationType {

    @Builder
    public WalkIn(Long id, Visitation visitation) {
        super(id, visitation);
    }
}
