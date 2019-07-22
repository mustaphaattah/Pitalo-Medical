package pitalo.domain.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Insurance extends BaseEntity {

    private String provider;
    private LocalDate expiryDate;
    private String policyNumber;
    private String groupNumber;

}
