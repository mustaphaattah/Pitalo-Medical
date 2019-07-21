package pitalo.domain.Patient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedicalHistoryTest {

    static MedicalHistory medicalHistory;

    static final Set<String> ALLERGIES = new HashSet<>(Arrays.asList("Peanuts", "Shellfish"));
    static final Set<String> LIFESTYLE = new HashSet<>(Arrays.asList("Smoking"));
    static final Set<String> ILLNESSES = new HashSet<>(Arrays.asList("Diabetes"));
    static final Set<String> MEDICATIONS = new HashSet<>(Arrays.asList("Insulin"));

    @BeforeAll
    static void setUp() {

        medicalHistory = MedicalHistory
            .builder()
            .allergies(ALLERGIES)
            .lifeStyle(LIFESTYLE)
            .illnesses(ILLNESSES)
            .medications(MEDICATIONS)
            .build();
    }

    @Test
    void testSizeValues() {

        assertEquals(2, medicalHistory.getAllergies().size());
        assertEquals(1, medicalHistory.getLifeStyle().size());
    }

    @Test
    void testEmptyValues() {

        assertNull(medicalHistory.getInjuries());
        assertNull(medicalHistory.getSurgeries());
    }

    @Test
    void testSetValues() {

        assertTrue(medicalHistory.getIllnesses().contains("Diabetes"));
        assertFalse(medicalHistory.getMedications().contains("Panadol"));
    }
}