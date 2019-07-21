package pitalo.domain.Visitation.VisitationType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmergencyCodeTest {

    private static final String CODE = "99283";
    private static final String STATUS = "Moderate Severity";

    static EmergencyCode eCode;

    @BeforeAll
    static void setUp() {
        eCode = EmergencyCode
            .builder()
            .code(CODE)
            .status(STATUS)
            .build();
    }

    @Test
    void checkCode() {
        assertEquals(CODE, eCode.getCode());
    }

    @Test
    void checkStatus() {
        assertEquals(STATUS, eCode.getStatus());
    }

    @Test
    void checkCodeNotNull() {
        assertNotNull(eCode.getCode());
    }

    @Test
    void checkStatusNotNull() {
        assertNotNull(eCode.getStatus());
    }
}