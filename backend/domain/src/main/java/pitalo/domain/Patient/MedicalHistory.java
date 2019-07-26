package pitalo.domain.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistory extends BaseEntity {

    @ElementCollection
    private List<String> allergies;

    @ElementCollection
    private List<String> illnesses;

    @ElementCollection
    private List<String> injuries;

    @ElementCollection
    private List<String> surgeries;

    @ElementCollection
    private List<String> medications;

    @ElementCollection
    private List<String> lifeStyle;

    @OneToOne(mappedBy = "medicalHistory")
    private Patient patient;

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
