package pitalo.domain.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmergencyContact extends BaseEntity {

    @NotEmpty(message = "First Name is required")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    private String lastName;

    @NotEmpty(message = "Relationship is required")
    private String relationship;

    @NotEmpty(message = "Phone number is required")
    @Column(name = "phone_number")
    @Pattern(regexp = "(\\d{3})[\\-]?\\d{3}[\\-]?\\d{4}", message = "Phone number must match format: (123)-123-1234")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Builder
    public EmergencyContact(Long id, String firstName, String lastName, String relationship, String phoneNumber, Patient patient) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
        this.patient = patient;
    }
}
