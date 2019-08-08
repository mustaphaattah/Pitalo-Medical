package pitalo.domain.Visitation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
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
@EqualsAndHashCode(callSuper = false)
public class Visitation extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "type_id")
    private VisitationType visitationType;

    @OneToOne(cascade = CascadeType.ALL)
    private Vitals vitals;

    @ManyToOne
    @JoinColumn(name = "nurse_id")
    @JsonIgnore
    private Nurse nurse;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnore
    private Doctor doctor;

    private String diagnosis;

    private String complaint;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time;

    private Status status;

    @Builder
    public Visitation(Long id, VisitationType visitationType, Vitals vitals, Nurse nurse, Doctor doctor, String diagnosis, String complaint, Patient patient, LocalDateTime time, Status status) {
        super(id);
        this.visitationType = visitationType;
        this.vitals = vitals;
        this.nurse = nurse;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.complaint = complaint;
        this.patient = patient;
        this.time = time;
        this.status = status;
    }

    @PrePersist
    protected void init() {

        if (this.time == null)
            this.time = LocalDateTime.now();

        if (this.status == null)
            this.status = Status.Pending;
    }
}
