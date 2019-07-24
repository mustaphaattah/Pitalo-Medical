package pitalo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Sex sex;
    private LocalDateTime registrationDate;
    private Address address;
}
