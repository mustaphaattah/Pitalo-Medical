package pitalo.domain.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Address;
import pitalo.domain.Person;
import pitalo.domain.Sex;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient extends Person {

    private MedicalHistory medicalHistory;
    private Insurance insurance;
    private Set<EmergencyContact> emergencyContacts;
    private Set<Visitation> visitations;
    private String occupation;

    @Builder
    public Patient(Long id, String firstName, String lastName, String middleName, Sex sex, LocalDateTime registrationDate, Address address, MedicalHistory medicalHistory, Insurance insurance, Set<EmergencyContact> emergencyContacts, Set<Visitation> visitations, String occupation) {
        super(id, firstName, lastName, middleName, sex, registrationDate, address);
        this.medicalHistory = medicalHistory;
        this.insurance = insurance;
        this.emergencyContacts = emergencyContacts;
        this.visitations = visitations;
        this.occupation = occupation;
    }
}
