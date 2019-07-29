package pitalo.domain.Staff;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import pitalo.domain.Address;
import pitalo.domain.Person;
import pitalo.domain.Sex;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Nurse extends Person {

    @Singular("visitation")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nurse")
    private Set<Visitation> visitations;

    @Builder
    public Nurse(Long id, @NotEmpty(message = "FirstName is required") String firstName, @NotEmpty(message = "LastName is required") String lastName, String middleName, @Email String email, @NotNull Sex sex, LocalDateTime registrationDate, Address address, @NotEmpty(message = "Phone number is required") @Pattern(regexp = "(\\d{3})[\\-]?\\d{3}[\\-]?\\d{4}", message = "Phone number must match format: (123)-123-1234") String phoneNumber, Set<Visitation> visitations) {
        super(id, firstName, lastName, middleName, email, sex, registrationDate, address, phoneNumber);
        this.visitations = visitations;
    }
}
