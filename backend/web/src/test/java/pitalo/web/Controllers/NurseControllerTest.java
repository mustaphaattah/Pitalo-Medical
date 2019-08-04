package pitalo.web.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pitalo.domain.Staff.Nurse;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Services.NurseService;
import pitalo.persistence.Services.VisitationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class NurseControllerTest {

    @Mock
    NurseService nurseService;

    @Mock
    VisitationService visitationService;

    @InjectMocks
    NurseController nurseController;

    MockMvc mockMvc;

    List<Nurse> nurses = new ArrayList<>();
    List<Visitation> visitations = new ArrayList<>();

    private static final Long NURSE_ID1 = 1L;
    private static final Long NURSE_ID2 = 2L;

    private static final Long VISITATION_ID1 = 3L;
    private static final Long VISITATION_ID2 = 4L;

    private static final String NURSE_NAME1 = "John";
    private static final String NURSE_NAME2 = "Mary";

    Nurse john;
    Nurse mary;

    Visitation visitation1;
    Visitation visitation2;

    @BeforeEach
    void setUp() {
        john = Nurse
            .builder()
            .id(NURSE_ID1)
            .firstName(NURSE_NAME1)
            .build();

        mary = Nurse
            .builder()
            .id(NURSE_ID2)
            .firstName(NURSE_NAME2)
            .build();


        nurses.add(john);
        nurses.add(mary);

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
            .standaloneSetup(nurseController)
            .build();
    }

    @Test
    void returnAllNurses() throws Exception {
        when(nurseService.findAll()).thenReturn(nurses);

        mockMvc.perform(get("/api/nurses"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id").value(NURSE_ID1))
            .andExpect(jsonPath("$[0].firstName").value(NURSE_NAME1));

        verify(nurseService).findAll();
    }

    @Test
    void findNurseByID() throws Exception {

        when(nurseService.findById(anyLong())).thenReturn(mary);

        mockMvc.perform(get("/api/nurses/4"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.id").value(2L))
            .andExpect(jsonPath("$.firstName").value(NURSE_NAME2));

        verify(nurseService).findById(anyLong());
    }

    @Test
    void findVisitationsWithTypeAndStatusByNurse() throws Exception {

        when(nurseService.findById(anyLong())).thenReturn(john);

        when(visitationService.findAllByNurse(any(), any(),any()))
            .thenReturn(Arrays.asList(visitation2));


        mockMvc.perform(get("/api/nurses/4/visitations")
            .param("type", "Emergency")
            .param("status", "Pending"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(VISITATION_ID2));

    }

}