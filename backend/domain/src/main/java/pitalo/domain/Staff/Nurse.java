package pitalo.domain.Staff;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Address;
import pitalo.domain.Person;
import pitalo.domain.Sex;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Nurse extends Person {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nurse")
    private List<Visitation> visitations;

    @Builder
    public Nurse(Long id, @NotEmpty(message = "FirstName is required") String firstName, @NotEmpty(message = "LastName is required") String lastName, String middleName, String email, @NotNull Sex sex, LocalDateTime registrationDate, Address address, List<Visitation> visitations) {
        super(id, firstName, lastName, middleName, email, sex, registrationDate, address);
        this.visitations = visitations;
    }
}
