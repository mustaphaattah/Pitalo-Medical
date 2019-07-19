package pitalo.domain.Visitation.VisitationType;

import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDateTime;
import java.time.Month;

class EmergencyTest {

    static Emergency emergency;
    static final String COMPLAINT = "Stabbed in the heart";
    static final LocalDateTime DATE_TIME = LocalDateTime.of(2019, Month.JULY, 10, 19, 32);

    @BeforeAll
    static void setUp() {
    }
}