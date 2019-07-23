package pitalo.domain.Visitation.VisitationType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class WalkIn extends BaseEntity implements VisitationType {

    @Builder
    public WalkIn(Long id) {
        super(id);
    }
}
