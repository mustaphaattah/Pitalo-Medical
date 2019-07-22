package pitalo.domain.Visitation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Vitals extends BaseEntity {

    private String bloodPressure;
    private String bodyTemperature;
    private String pulseRate;
    private String weight;
    private String height;
    private String respirationRate;
    private BloodType bloodType;
    private Visitation visitation;

}
