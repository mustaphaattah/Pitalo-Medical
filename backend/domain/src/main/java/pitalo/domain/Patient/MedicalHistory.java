package pitalo.domain.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MedicalHistory extends BaseEntity {

    private Set<String> allergies;
    private Set<String> illnesses;
    private Set<String> injuries;
    private Set<String> surgeries;
    private Set<String> medications;
    private Set<String> lifeStyle;


}
