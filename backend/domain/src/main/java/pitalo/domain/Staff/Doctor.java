package pitalo.domain.Staff;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Address;
import pitalo.domain.Person;
import pitalo.domain.Sex;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
public class Doctor extends Person {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @Builder
    public Doctor(Long id, String firstName, String lastName, String middleName, Sex sex, LocalDateTime registrationDate, Address address, Specialty specialty) {
        super(id, firstName, lastName, middleName, sex, registrationDate, address);
        this.specialty = specialty;
    }
}
