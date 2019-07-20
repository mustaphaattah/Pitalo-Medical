package pitalo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
    private String middleName;
    private Sex sex;
    private LocalDateTime registrationDate;
    private Address address;

    @Builder
    public Person(Long id, String firstName, String lastName, String middleName, Sex sex, LocalDateTime registrationDate, Address address) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.sex = sex;
        this.registrationDate = registrationDate;
        this.address = address;
    }
}
