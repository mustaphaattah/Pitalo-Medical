package pitalo.web.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pitalo.domain.Staff.Doctor;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Services.DoctorService;
import pitalo.persistence.Services.VisitationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class DoctorControllerTest {
    @Mock
    DoctorService doctorService;

    @Mock
    VisitationService visitationService;

    @InjectMocks
    DoctorController doctorController;

    MockMvc mockMvc;

    List<Doctor> doctors = new ArrayList<>();
    List<Visitation> visitations = new ArrayList<>();

    private static final Long DOCTOR_ID1 = 1L;
    private static final Long DOCTOR_ID2 = 2L;

    private static final Long VISITATION_ID1 = 3L;
    private static final Long VISITATION_ID2 = 4L;

    private static final String DOCTOR_NAME1 = "John";
    private static final String DOCTOR_NAME2 = "Mary";

    Doctor john;
    Doctor mary;

    Visitation visitation1;
    Visitation visitation2;

    @BeforeEach
    void setUp() {
        john = Doctor
            .builder()
            .id(DOCTOR_ID1)
            .firstName(DOCTOR_NAME1)
            .build();

        mary = Doctor
            .builder()
            .id(DOCTOR_ID2)
            .firstName(DOCTOR_NAME2)
            .build();


        doctors.add(john);
        doctors.add(mary);

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
            .standaloneSetup(doctorController)
            .build();
    }

    @Test
    void returnAllDoctors() throws Exception {
        when(doctorService.findAll()).thenReturn(doctors);

        mockMvc.perform(get("/api/doctors"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id").value(DOCTOR_ID1))
            .andExpect(jsonPath("$[0].firstName").value(DOCTOR_NAME1));

        verify(doctorService).findAll();
    }

    @Test
    void findDoctorByID() throws Exception {

        when(doctorService.findById(anyLong())).thenReturn(mary);

        mockMvc.perform(get("/api/doctors/4"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.id").value(2L))
            .andExpect(jsonPath("$.firstName").value(DOCTOR_NAME2));

        verify(doctorService).findById(anyLong());
    }

    @Test
    void findVisitationsWithTypeAndStatusByDoctor() throws Exception {

        when(doctorService.findById(anyLong())).thenReturn(john);

        when(visitationService.findAllByDoctor(any(), any(),any()))
            .thenReturn(Arrays.asList(visitation2));


        mockMvc.perform(get("/api/doctors/4/visitations")
            .param("type", "Emergency")
            .param("status", "Pending"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].id").value(VISITATION_ID2));

    }

}