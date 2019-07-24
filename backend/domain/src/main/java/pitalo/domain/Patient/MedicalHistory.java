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
public class MedicalHistory extends BaseEntity {

    private List<String> allergies;
    private List<String> illnesses;
    private List<String> injuries;
    private List<String> surgeries;
    private List<String> medications;
    private List<String> lifeStyle;

    @Builder
    public MedicalHistory(Long id, List<String> allergies, List<String> illnesses, List<String> injuries, List<String> surgeries, List<String> medications, List<String> lifeStyle) {
        super(id);
        this.allergies = allergies;
        this.illnesses = illnesses;
        this.injuries = injuries;
        this.surgeries = surgeries;
        this.medications = medications;
        this.lifeStyle = lifeStyle;
    }
}
