package pitalo.domain.Visitation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pitalo.domain.BaseEntity;
import pitalo.domain.Patient.Patient;
import pitalo.domain.Staff.Doctor;
import pitalo.domain.Staff.Nurse;
import pitalo.domain.Visitation.VisitationType.VisitationType;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitation extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "type_id")
    private VisitationType visitationType;

    @OneToOne(cascade = CascadeType.ALL)
    private Vitals vitals;

    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private String diagnosis;

    private String complaint;

    @ManyToOne
    @JoinColumn(name = "visitations")
    private Patient patient;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
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
