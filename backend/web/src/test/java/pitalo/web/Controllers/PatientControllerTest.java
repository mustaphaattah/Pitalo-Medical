package pitalo.web.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pitalo.domain.Patient.Patient;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Services.PatientService;
import pitalo.persistence.Services.VisitationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PatientControllerTest {

    @Mock
    PatientService patientService;

    @Mock
    VisitationService visitationService;

    @InjectMocks
    PatientController patientController;

    MockMvc mockMvc;

    List<Patient> patients = new ArrayList<>();
    List<Visitation> visitations = new ArrayList<>();

    private static final Long PATIENT_ID1 = 1L;
    private static final Long PATIENT_ID2 = 2L;

    private static final Long VISITATION_ID1 = 3L;
    private static final Long VISITATION_ID2 = 4L;

    private static final String PATIENT_NAME1 = "John";
    private static final String PATIENT_NAME2 = "Mary";

    Patient john;
    Patient mary;

    Visitation visitation1;
    Visitation visitation2;

    @BeforeEach
    void setUp() {
        john = Patient
            .builder()
            .id(PATIENT_ID1)
            .firstName(PATIENT_NAME1)
            .build();

        mary = Patient
            .builder()
            .id(PATIENT_ID2)
            .firstName(PATIENT_NAME2)
            .build();


        patients.add(john);
        patients.add(mary);

        visitation1 = Visitation
            .builder()
            .id(VISITATION_ID1)
            .build();

        visitation2 = Visitation
            .builder()
            .id(VISITATION_ID2)
            .build();

        visitations.add(visitation1);
        visitations.add(visitation2);

        mockMvc = MockMvcBuilders
            .standaloneSetup(patientController)
            .build();
    }

    @Test
    void returnAllPatients() throws Exception {
        when(patientService.findAll()).thenReturn(patients);

        mockMvc.perform(get("/api/patients"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id").value(PATIENT_ID1))
            .andExpect(jsonPath("$[0].firstName").value(PATIENT_NAME1));

        verify(patientService).findAll();
        verify(patientService, never()).findAll(anyString(), anyString());
    }

    @Test
    void returnPatientsSearchBy() throws Exception {

        when(patientService.findAll(anyString(), anyString())).thenReturn(Arrays.asList(john));

        mockMvc.perform(get("/api/patients")
            .param("searchBy", "firstName")
            .param("value", "John"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(PATIENT_ID1))
                .andExpect(jsonPath("$[0].firstName").value(PATIENT_NAME1));

        verify(patientService).findAll(anyString(), anyString());
        verify(patientService, never()).findAll();
    }

    @Test
    void findPatientByID() throws Exception {

        when(patientService.findById(anyLong())).thenReturn(mary);

        mockMvc.perform(get("/api/patients/4"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.id").value(2L))
            .andExpect(jsonPath("$.firstName").value(PATIENT_NAME2));

        verify(patientService).findById(anyLong());
    }

    @Test
    void findVisitationsByPatient() throws Exception {

        when(patientService.findById(anyLong())).thenReturn(john);

        when(visitationService.findAllByPatient(any(), any()))
            .thenReturn(visitations);


        mockMvc.perform(get("/api/patients/4/visitations"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$", hasSize(2)));


        verify(patientService).findById(anyLong());
        verify(visitationService).findAllByPatient(any(), any());
    }
}