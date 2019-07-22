package pitalo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Address extends BaseEntity {

    private String postalCode;
    private String city;
    private String province;
    private String addressLine1;
    private String addressLine2;

    private Person person;
}
