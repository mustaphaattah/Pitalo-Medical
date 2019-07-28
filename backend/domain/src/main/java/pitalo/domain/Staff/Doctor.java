package pitalo.domain.Staff;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import pitalo.domain.Address;
import pitalo.domain.Person;
import pitalo.domain.Sex;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Doctor extends Person {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @Singular("visitation")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Visitation> visitations;

    @Builder
    public Doctor(Long id, @NotEmpty(message = "FirstName is required") String firstName, @NotEmpty(message = "LastName is required") String lastName, String middleName, @Email String email, @NotNull Sex sex, LocalDateTime registrationDate, Address address, @NotEmpty(message = "Phone number is required") @Pattern(regexp = "(\\d{3})[\\-]?\\d{3}[\\-]?\\d{4}", message = "Phone number must match format: (123)-123-1234") String phoneNumber, Specialty specialty, List<Visitation> visitations) {
        super(id, firstName, lastName, middleName, email, sex, registrationDate, address, phoneNumber);
        this.specialty = specialty;
        this.visitations = visitations;
    }
}
