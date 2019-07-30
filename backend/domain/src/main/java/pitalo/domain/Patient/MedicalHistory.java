package pitalo.domain.Patient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pitalo.domain.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"patient"})
public class MedicalHistory extends BaseEntity {

    @Singular("allergy")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> allergies;

    @Singular("illness")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> illnesses;

    @Singular("injury")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> injuries;

    @Singular("surgery")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> surgeries;

    @Singular("medication")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> medications;

    @Singular("lifeStyle")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> lifeStyle;

    @Column(name = "blood_type")
    private BloodType bloodType;

    @JsonIgnore
    @OneToOne(mappedBy = "medicalHistory")
    private Patient patient;

    public MedicalHistory(Long id, Set<String> allergies, Set<String> illnesses, Set<String> injuries, Set<String> surgeries, Set<String> medications, Set<String> lifeStyle, BloodType bloodType) {
        super(id);
        this.allergies = allergies;
        this.illnesses = illnesses;
        this.injuries = injuries;
        this.surgeries = surgeries;
        this.medications = medications;
        this.lifeStyle = lifeStyle;
        this.bloodType = bloodType;
    }
}
