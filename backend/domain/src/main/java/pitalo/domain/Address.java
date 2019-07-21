package pitalo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private String postalCode;
    private String city;
    private String province;
    private String addressLine1;
    private String addressLine2;

    private Person person;
}
