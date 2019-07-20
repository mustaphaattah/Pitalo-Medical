package pitalo.domain.Patient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmergencyContactTest {

    static EmergencyContact emergencyContact;

    static final String RELATIONSHIP = "Father";
    static final String PHONE_NUMBER = "613-777-7777";

    @BeforeAll
    static void setUp() {

        emergencyContact = EmergencyContact
            .builder()
            .relationship(RELATIONSHIP)
            .phoneNumber(PHONE_NUMBER)
            .build();
    }

    @Test
    void checkValues() {
        assertEquals(RELATIONSHIP, emergencyContact.getRelationship());
        assertEquals(PHONE_NUMBER, emergencyContact.getPhoneNumber());
    }
}