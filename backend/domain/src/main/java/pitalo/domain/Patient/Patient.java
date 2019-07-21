package pitalo.domain.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pitalo.domain.Person;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.Entity;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Patient extends Person {

    private MedicalHistory medicalHistory;
    private Insurance insurance;
    private Set<EmergencyContact> emergencyContacts;
    private Set<Visitation> visitations;
    private String occupation;
}
