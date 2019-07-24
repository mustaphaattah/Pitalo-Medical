package pitalo.domain.Visitation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;
import pitalo.domain.Patient.Patient;
import pitalo.domain.Staff.Doctor;
import pitalo.domain.Staff.Nurse;
import pitalo.domain.Visitation.VisitationType.VisitationType;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitation extends BaseEntity {

    private VisitationType visitationType;
    private Vitals vitals;
    private Nurse nurse;
    private Doctor doctor;
    private String diagnosis;
    private String complaint;
    private Patient patient;
    private LocalDateTime time;

    @Builder
    public Visitation(Long id, VisitationType visitationType, Vitals vitals, Nurse nurse, Doctor doctor, String diagnosis, String complaint, Patient patient, LocalDateTime time) {
        super(id);
        this.visitationType = visitationType;
        this.vitals = vitals;
        this.nurse = nurse;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.complaint = complaint;
        this.patient = patient;
        this.time = time;
    }
}
