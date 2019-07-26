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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmergencyContact extends BaseEntity {

    @NotEmpty(message = "Relationship is required")
    private String relationship;

    @NotEmpty(message = "Phone number is required")
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Builder
    public EmergencyContact(Long id, String relationship, String phoneNumber, Patient patient) {
        super(id);
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
        this.patient = patient;
    }
}
