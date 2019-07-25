package pitalo.domain.Staff;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Address;
import pitalo.domain.Person;
import pitalo.domain.Sex;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Nurse extends Person {

    @Builder
    public Nurse(Long id, String firstName, String lastName, String middleName, Sex sex, LocalDateTime registrationDate, Address address) {
        super(id, firstName, lastName, middleName, sex, registrationDate, address);
    }
}
