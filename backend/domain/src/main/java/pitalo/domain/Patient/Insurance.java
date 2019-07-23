package pitalo.domain.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Insurance extends BaseEntity {

    private String provider;
    private LocalDate expiryDate;
    private String policyNumber;
    private String groupNumber;

    @Builder
    public Insurance(Long id, String provider, LocalDate expiryDate, String policyNumber, String groupNumber) {
        super(id);
        this.provider = provider;
        this.expiryDate = expiryDate;
        this.policyNumber = policyNumber;
        this.groupNumber = groupNumber;
    }
}
