package pitalo.domain.Patient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pitalo.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"patient"})
public class Insurance extends BaseEntity {

    @NotEmpty(message = "Provider is required")
    private String provider;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @NotEmpty(message = "Policy number is required")
    @Column(name = "policy_number")
    private String policyNumber;

    @NotEmpty(message = "Group number is required")
    @Column(name = "group_number")
    private String groupNumber;

    @JsonIgnore
    @OneToOne(mappedBy = "insurance")
    private Patient patient;

    @Builder
    public Insurance(Long id, String provider, LocalDate expiryDate, String policyNumber, String groupNumber) {
        super(id);
        this.provider = provider;
        this.expiryDate = expiryDate;
        this.policyNumber = policyNumber;
        this.groupNumber = groupNumber;
    }
}
