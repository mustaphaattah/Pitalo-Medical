package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Visitation.VisitationType.WalkIn;
import pitalo.persistence.Repositories.WalkInRepository;

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
class WalkInServiceTest {

    @Mock
    WalkInRepository walkInRepository;

    @InjectMocks
    WalkInService walkInService;

    WalkIn walkIn;
    static final Long ID = 1L;

    @BeforeEach
    void setUp() {
        walkIn = WalkIn
            .builder()
            .id(ID)
            .build();
    }

    @Test
    void findAll() {

        List<WalkIn> walkIns = new ArrayList<>();
        walkIns.add(walkIn);

        when(walkInRepository.findAll()).thenReturn(walkIns);

        List<WalkIn> walkInList = walkInService.findAll();
        assertThat(walkInList.size()).isEqualTo(1);
    }

    @Test
    void findById() {
        when(walkInRepository.findById(anyLong())).thenReturn(Optional.of(walkIn));

        WalkIn walkin = walkInService.findById(ID);
        assertNotNull(walkin);
    }

    @Test
    void findByIdReturnNull() {
        when(walkInRepository.findById(anyLong())).thenReturn(Optional.empty());
        WalkIn walkIn = walkInService.findById(ID);
        assertNull(walkIn);
    }

    @Test
    void save() {
        when(walkInRepository.save(any(WalkIn.class))).thenReturn(walkIn);
        WalkIn savedWalkIn = walkInService.save(walkIn);

        assertNotNull(walkIn);
        verify(walkInRepository).save(any(WalkIn.class));
    }

    @Test
    void delete() {
        walkInService.delete(walkIn);
        verify(walkInRepository).delete(any(WalkIn.class));
    }

    @Test
    void deleteById() {
        walkInService.deleteById(ID);
        verify(walkInRepository).deleteById(anyLong());
    }
}