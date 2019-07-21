package pitalo.domain.Staff;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pitalo.domain.Person;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Staff extends Person {

    private String salary;
    private Specialty specialty;
}
