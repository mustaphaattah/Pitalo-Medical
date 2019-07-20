package pitalo.domain.Visitation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vitals extends BaseEntity {

    private String bloodPressure;
    private String bodyTemperature;
    private String pulseRate;
    private String weight;
    private String height;
    private String respirationRate;
    private BloodType bloodType;
    private Visitation visitation;

    @Builder
    public Vitals(Long id, String bloodPressure, String bodyTemperature, String pulseRate, String weight, String height, String respirationRate, BloodType bloodType, Visitation visitation) {
        super(id);
        this.bloodPressure = bloodPressure;
        this.bodyTemperature = bodyTemperature;
        this.pulseRate = pulseRate;
        this.weight = weight;
        this.height = height;
        this.respirationRate = respirationRate;
        this.bloodType = bloodType;
        this.visitation = visitation;
    }
}
