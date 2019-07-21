package pitalo.domain.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Insurance {

    private String provider;
    private LocalDate expiryDate;
    private String policyNumber;
    private String groupNumber;

}
