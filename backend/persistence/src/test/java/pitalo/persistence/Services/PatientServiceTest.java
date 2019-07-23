package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Patient.Patient;
import pitalo.persistence.Repositories.PatientRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    PatientService patientService;

    Patient patient1;
    Patient patient2;

    static final Long ID_1 = 1L;
    static final Long ID_2 = 2L;
    static final String NAME_1 = "John";
    static final String NAME_2 = "Clara";

    @BeforeEach
    void ListUp() {
        patient1 = Patient
            .builder()
            .id(ID_1)
            .firstName(NAME_1)
            .build();



        patient2 = Patient
            .builder()
            .id(ID_2)
            .firstName(NAME_2)
            .build();
    }

    @Test
    @DisplayName("Find all patients in the repository")
    void findAll() {
        List<Patient> patients = new ArrayList<>();
        patients.add(patient1);
        patients.add(patient2);

        when(patientRepository.findAll()).thenReturn(patients);

        List<Patient> patientList = patientService.findAll();
        assertThat(patientList.size()).isEqualTo(2);
    }
}