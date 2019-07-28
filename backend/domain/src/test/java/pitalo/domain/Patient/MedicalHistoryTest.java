package pitalo.domain.Patient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MedicalHistoryTest {

    static MedicalHistory medicalHistory;

    static final List<String> ALLERGIES = new ArrayList<>(Arrays.asList("Peanuts", "Shellfish"));
    static final List<String> LIFESTYLE = new ArrayList<>(Arrays.asList("Smoking"));
    static final List<String> ILLNESSES = new ArrayList<>(Arrays.asList("Diabetes"));
    static final List<String> MEDICATIONS = new ArrayList<>(Arrays.asList("Insulin"));

    @BeforeAll
    static void ListUp() {

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

        assertThat(medicalHistory.getInjuries()).isEmpty();
        assertThat(medicalHistory.getSurgeries()).isEmpty();
    }

    @Test
    void testListValues() {

        assertTrue(medicalHistory.getIllnesses().contains("Diabetes"));
        assertFalse(medicalHistory.getMedications().contains("Panadol"));
    }
}