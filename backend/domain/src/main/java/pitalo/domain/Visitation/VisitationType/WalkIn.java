package pitalo.domain.Visitation.VisitationType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@Entity
public class WalkIn extends VisitationType {

    @OneToOne(mappedBy = "visitationType")
    private Visitation visitation;

    @Builder
    public WalkIn(Long id, Visitation visitation) {
        super(id, visitation);
    }
}
