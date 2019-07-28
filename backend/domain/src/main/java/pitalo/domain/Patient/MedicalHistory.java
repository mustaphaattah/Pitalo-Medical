package pitalo.domain.Patient;

import lombok.*;
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

    @Singular("allergy")
    @ElementCollection
    private List<String> allergies;

    @Singular("illness")
    @ElementCollection
    private List<String> illnesses;

    @Singular("injury")
    @ElementCollection
    private List<String> injuries;

    @Singular("surgery")
    @ElementCollection
    private List<String> surgeries;

    @Singular("medication")
    @ElementCollection
    private List<String> medications;

    @Singular("lifeStyle")
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
