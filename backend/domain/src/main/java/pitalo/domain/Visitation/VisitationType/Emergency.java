package pitalo.domain.Visitation.VisitationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Emergency extends BaseEntity implements VisitationType  {

    private EmergencyCode emergencyCode;

    @Builder
    public Emergency(Long id, EmergencyCode emergencyCode) {
        super(id);
        this.emergencyCode = emergencyCode;
    }
}
