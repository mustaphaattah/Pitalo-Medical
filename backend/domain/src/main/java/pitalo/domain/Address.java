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
public class Address extends BaseEntity {

    private String postalCode;
    private String city;
    private String province;
    private String addressLine1;
    private String addressLine2;

    private Person person;

    @Builder
    public Address(Long id, String postalCode, String city, String province, String addressLine1, String addressLine2, Person person) {
        super(id);
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.person = person;
    }
}
