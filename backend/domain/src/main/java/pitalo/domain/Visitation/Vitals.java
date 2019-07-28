package pitalo.domain.Visitation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vitals extends BaseEntity {

    @NotEmpty(message = "Blood Pressure is required")
    @Column(name = "blood_pressure")
    private String bloodPressure;

    @NotEmpty(message = "Body Temperature is required")
    @Column(name = "body_temperature")
    private String bodyTemperature;

    @NotEmpty(message = "Pulse rate is required")
    @Column(name = "pulse_rate")
    private String pulseRate;

    @NotEmpty(message = "Weight is required")
    private String weight;

    private String height;

    @NotEmpty(message = "Respiration rate is required")
    @Column(name = "respiration_rate")
    private String respirationRate;



    @OneToOne(mappedBy = "vitals")
    private Visitation visitation;

    @Builder
    public Vitals(Long id, String bloodPressure, String bodyTemperature, String pulseRate, String weight, String height, String respirationRate, Visitation visitation) {
        super(id);
        this.bloodPressure = bloodPressure;
        this.bodyTemperature = bodyTemperature;
        this.pulseRate = pulseRate;
        this.weight = weight;
        this.height = height;
        this.respirationRate = respirationRate;
        this.visitation = visitation;
    }
}
