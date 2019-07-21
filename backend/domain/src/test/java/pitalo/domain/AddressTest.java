package pitalo.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressTest {

    static Address address;
    
    //    Address details
    static final String ADDRESS_LINE1 = "80 Lass Avenue";
    static final String ADDRESS_LINE2 = "Nepean";
    static final String CITY = "Ottawa";
    static final String PROVINCE = "Ontario";
    static final String POSTAL_CODE = "K9W 8TB";
    
    @BeforeAll
    static void setUp() {
        address = Address
            .builder()
            .addressLine1(ADDRESS_LINE1)
            .addressLine2(ADDRESS_LINE2)
            .city(CITY)
            .province(PROVINCE)
            .postalCode(POSTAL_CODE)
            .build();
    }

    @Test
    void checkValues() {
        assertEquals(ADDRESS_LINE1, address.getAddressLine1());
        assertEquals(ADDRESS_LINE2, address.getAddressLine2());
        assertEquals(CITY, address.getCity());
        assertEquals(PROVINCE, address.getProvince());
        assertEquals(POSTAL_CODE, address.getPostalCode());
    }

}