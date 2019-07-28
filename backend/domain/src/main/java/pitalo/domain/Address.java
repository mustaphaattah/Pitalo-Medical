package pitalo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

    @NotEmpty(message = "Postal Code is required")
    @Pattern(regexp = "^[A-Z][0-9][A-Z] [0-9][A-Z][0-9]$", message = "Postal Code must match format: K1G 4A0")
    private String postalCode;

    @NotEmpty(message = "City is required")
    private String city;

    @NotEmpty(message = "Province is required")
    @Pattern(regexp = "[A-Z]{2}", message = "Province must match format: ON")
    private String province;

    @NotEmpty(message = "Address is required")
    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @OneToOne(mappedBy = "address")
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
