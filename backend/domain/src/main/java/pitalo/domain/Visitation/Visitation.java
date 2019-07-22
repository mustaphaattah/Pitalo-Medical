package pitalo.domain.Visitation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
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
@SuperBuilder
public class Visitation extends BaseEntity {

    private VisitationType visitationType;
    private Vitals vitals;
    private Nurse nurse;
    private Doctor doctor;
    private String diagnosis;
    private String complaint;
    private Patient patient;
    private LocalDateTime time;
}
