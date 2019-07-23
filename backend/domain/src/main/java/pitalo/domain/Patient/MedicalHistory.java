package pitalo.domain.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalHistory extends BaseEntity {

    private List<String> allergies;
    private List<String> illnesses;
    private List<String> injuries;
    private List<String> surgeries;
    private List<String> medications;
    private List<String> lifeStyle;


}
