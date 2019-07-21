package pitalo.domain.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalHistory {

    private Set<String> allergies;
    private Set<String> illnesses;
    private Set<String> injuries;
    private Set<String> surgeries;
    private Set<String> medications;
    private Set<String> lifeStyle;


}
