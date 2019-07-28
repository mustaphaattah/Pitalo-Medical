package pitalo.domain.Visitation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VitalsTest {

    static Vitals vitals;
    static final Long ID = 1L;
    static final String BLOOD_PRESSURE = "130/85";
    static final String PULSE_RATE = "80";
    static final String BODY_TEMPERATURE = "98.2F";
    static final String RESPIRATION_RATE = "15";
    static final String WEIGHT = "160kg";
    static final String HEIGHT = "6'0";


    @BeforeAll
    static void setUp() {
        vitals = Vitals
            .builder()
            .bloodPressure(BLOOD_PRESSURE)
            .bodyTemperature(BODY_TEMPERATURE)
            .pulseRate(PULSE_RATE)
            .weight(WEIGHT)
            .height(HEIGHT)
            .respirationRate(RESPIRATION_RATE)
            .build();
    }


    @Test
    void checkValues() {
        assertEquals(BLOOD_PRESSURE, vitals.getBloodPressure());
        assertEquals(PULSE_RATE, vitals.getPulseRate());
        assertEquals(BODY_TEMPERATURE,vitals.getBodyTemperature());
        assertEquals(RESPIRATION_RATE, vitals.getRespirationRate());
        assertEquals(WEIGHT,vitals.getWeight());
        assertEquals(HEIGHT, vitals.getHeight());

        assertNull(vitals.getVisitation());
    }
}