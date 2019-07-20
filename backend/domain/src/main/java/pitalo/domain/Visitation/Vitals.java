package pitalo.domain.Visitation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vitals {

    private String bloodPressure;
    private String bodyTemperature;
    private String pulseRate;
    private String weight;
    private String height;
    private String respirationRate;
    private BloodType bloodType;
    private Visitation visitation;

}
