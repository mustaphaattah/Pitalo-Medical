package pitalo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
    private String middleName;
    private Sex sex;
    private LocalDateTime registrationDate;
    private Address address;
}
