package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Patient.MedicalHistory;
import pitalo.persistence.Repositories.MedicalHistoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedicalHistoryServiceTest {

    @Mock
    MedicalHistoryRepository medicalHistoryRepository;

    @InjectMocks
    MedicalHistoryService medicalHistoryService;

    MedicalHistory medicalHistory;
    static final Long ID = 2L;

    @BeforeEach
    void setUp() {
        medicalHistory = MedicalHistory
            .builder()
            .id(ID)
            .build();
    }

    @Test
    void findAll() {
        List<MedicalHistory> medicalHistories = new ArrayList<>();
        medicalHistories.add(medicalHistory);

        when(medicalHistoryRepository.findAll()).thenReturn(medicalHistories);
        List<MedicalHistory> histories = medicalHistoryService.findAll();

        assertThat(histories).isNotEmpty();
        verify(medicalHistoryRepository).findAll();
    }

    @Test
    void findById() {
        when(medicalHistoryRepository.findById(anyLong())).thenReturn(Optional.of(medicalHistory));
        MedicalHistory medicalHistory = medicalHistoryService.findById(ID);
        assertNotNull(medicalHistory);
    }

    @Test
    void findByIdNotFound() {
        when(medicalHistoryRepository.findById(anyLong())).thenReturn(Optional.empty());
        MedicalHistory medicalHistory = medicalHistoryService.findById(ID);
        assertNull(medicalHistory);
    }


    @Test
    void save() {
        when(medicalHistoryRepository.save(any(MedicalHistory.class))).thenReturn(medicalHistory);
        MedicalHistory savedHistory = medicalHistoryService.save(medicalHistory);

        assertNotNull(savedHistory);
        verify(medicalHistoryRepository, times(1)).save(any(MedicalHistory.class));
    }

    @Test
    void delete() {
        medicalHistoryService.delete(medicalHistory);
        verify(medicalHistoryRepository, times(1)).delete(any(MedicalHistory.class));
    }

    @Test
    void deleteById() {
        medicalHistoryService.deleteById(anyLong());
        verify(medicalHistoryRepository, times(1)).deleteById(anyLong());
    }
}