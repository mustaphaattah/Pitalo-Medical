package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Visitation.Vitals;
import pitalo.persistence.Repositories.VitalsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VitalsServiceTest {

    @Mock
    VitalsRepository vitalsRepository;

    @InjectMocks
    VitalsService vitalsService;

    Vitals vitals;
    static final Long ID = 2L;

    @BeforeEach
    void setUp() {
        vitals = Vitals
            .builder()
            .id(ID)
            .build();
    }

    @Test
    void findAll() {

        List<Vitals> vitalsList = new ArrayList<>();
        vitalsList.add(vitals);

        when(vitalsRepository.findAll()).thenReturn(vitalsList);

        List<Vitals> walkInList = vitalsService.findAll();
        assertThat(vitalsList.size()).isEqualTo(1);
    }

    @Test
    void findById() {
        when(vitalsRepository.findById(anyLong())).thenReturn(Optional.of(vitals));

        Vitals vitals = vitalsService.findById(ID);
        assertNotNull(vitals);
    }

    @Test
    void findByIdReturnNull() {
        when(vitalsRepository.findById(anyLong())).thenReturn(Optional.empty());
        Vitals vitals = vitalsService.findById(ID);
        assertNull(vitals);
    }

    @Test
    void save() {
        when(vitalsRepository.save(any(Vitals.class))).thenReturn(vitals);
        Vitals savedVitals = vitalsService.save(vitals);

        assertNotNull(vitals);
        verify(vitalsRepository).save(any(Vitals.class));
    }

    @Test
    void delete() {
        vitalsService.delete(vitals);
        verify(vitalsRepository).delete(any(Vitals.class));
    }

    @Test
    void deleteById() {
        vitalsService.deleteById(ID);
        verify(vitalsRepository).deleteById(anyLong());
    }
}