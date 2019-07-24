package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Visitation.VisitationType.Emergency;
import pitalo.persistence.Repositories.EmergencyRepository;

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
class EmergencyServiceTest {

    @Mock
    EmergencyRepository emergencyRepository;

    @InjectMocks
    EmergencyService emergencyService;

    Emergency emergency;
    static final Long ID = 9L;

    @BeforeEach
    void setUp() {
        emergency = Emergency
            .builder()
            .id(ID)
            .build();
    }

    @Test
    void findAll() {
        List<Emergency> emergencyList = new ArrayList<>();
        emergencyList.add(emergency);

        when(emergencyRepository.findAll()).thenReturn(emergencyList);
        List<Emergency> emergencies = emergencyService.findAll();

        assertThat(emergencies.size()).isNotZero();
        verify(emergencyRepository).findAll();
    }

    @Test
    void findById() {
        when(emergencyRepository.findById(anyLong())).thenReturn(Optional.of(emergency));
        Emergency emergency = emergencyService.findById(ID);
        assertNotNull(emergency);
    }

    @Test
    void findByIdNotFound() {
        when(emergencyRepository.findById(anyLong())).thenReturn(Optional.empty());
        Emergency emergency = emergencyService.findById(ID);
        assertNull(emergency);
    }

    @Test
    void save() {
        when(emergencyRepository.save(any(Emergency.class))).thenReturn(emergency);
        Emergency savedEmergency = emergencyService.save(emergency);

        assertNotNull(savedEmergency);
        verify(emergencyRepository, times(1)).save(any(Emergency.class));
    }

    @Test
    void delete() {
        emergencyService.delete(emergency);
        verify(emergencyRepository, times(1)).delete(any(Emergency.class));
    }

    @Test
    void deleteById() {
        emergencyService.deleteById(ID);
        verify(emergencyRepository, times(1)).deleteById(anyLong());
    }
}