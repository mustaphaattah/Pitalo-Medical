package pitalo.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    static Person person;
    static final Sex SEX = Sex.Male;
    static final String FIRST_NAME = "John";
    static final String LAST_NAME = "Boris";
    static final String MIDDLE_NAME = "P.";
    static final LocalDateTime REGISTRATION_DATE = LocalDateTime.of(2017, Month.JULY, 10, 11, 35);

//    Address details
    static final String ADDRESS_LINE1 = "80 Lass Avenue";
    static final String ADDRESS_LINE2 = "Nepean";
    static final String CITY = "Ottawa";
    static final String PROVINCE = "Ontario";
    static final String POSTAL_CODE = "K9W 8TB";


    @BeforeAll
    static void setUp() {
        Address address = Address
            .builder()
            .addressLine1(ADDRESS_LINE1)
            .addressLine2(ADDRESS_LINE2)
            .city(CITY)
            .province(PROVINCE)
            .postalCode(POSTAL_CODE)
            .build();

        person = Person
            .builder()
            .address(address)
            .registrationDate(REGISTRATION_DATE)
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .middleName(MIDDLE_NAME)
            .sex(SEX)
            .build();
    }

    @Test
    void checkValues() {
        assertEquals(FIRST_NAME, person.getFirstName());
        assertEquals(LAST_NAME, person.getLastName());
        assertEquals(SEX, person.getSex());
        assertEquals(MIDDLE_NAME, person.getMiddleName());
        assertEquals(REGISTRATION_DATE, person.getRegistrationDate());

    }

}