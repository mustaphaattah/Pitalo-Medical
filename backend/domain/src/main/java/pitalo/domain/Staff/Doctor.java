package pitalo.domain.Staff;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Address;
import pitalo.domain.Person;
import pitalo.domain.Sex;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Doctor extends Person {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Visitation> visitations;

    @Builder
    public Doctor(Long id, @NotEmpty(message = "FirstName is required") String firstName, @NotEmpty(message = "LastName is required") String lastName, String middleName, @NotNull Sex sex, LocalDateTime registrationDate, Address address, Specialty specialty, List<Visitation> visitations) {
        super(id, firstName, lastName, middleName, sex, registrationDate, address);
        this.specialty = specialty;
        this.visitations = visitations;
    }
}
