package pitalo.domain.Patient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsuranceTest {


    static Insurance insurance;

    static final String PROVIDER = "Insurance company";
    static final LocalDate EXPIRY_DATE = LocalDate.of(2021, Month.AUGUST, 23);
    static final String POLICY_NUMBER = "829481984";
    static final String GROUP_NUMBER = "09183";

    @BeforeAll
    static void setUp() {
        insurance = Insurance
            .builder()
            .provider(PROVIDER)
            .expiryDate(EXPIRY_DATE)
            .policyNumber(POLICY_NUMBER)
            .groupNumber(GROUP_NUMBER)
            .build();
    }

    @Test
    void checkValues() {
        assertEquals(PROVIDER, insurance.getProvider());
        assertEquals(EXPIRY_DATE, insurance.getExpiryDate());
        assertEquals(POLICY_NUMBER, insurance.getPolicyNumber());
        assertEquals(GROUP_NUMBER, insurance.getGroupNumber());
    }
}