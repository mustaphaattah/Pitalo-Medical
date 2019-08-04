package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Visitation.Visitation;
import pitalo.persistence.Exceptions.VisitationNotFoundException;
import pitalo.persistence.Repositories.VisitationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitationServiceTest {

    @Mock
    VisitationRepository visitationRepository;

    @InjectMocks
    VisitationService visitationService;

    Visitation visitation;
    static final Long ID = 3L;

    @BeforeEach
    void setUp() {
        visitation = Visitation
            .builder()
            .id(ID)
            .build();
    }

    @Test
    void findAll() {
        List<Visitation> visitations = new ArrayList<>();
        visitations.add(visitation);

        when(visitationRepository.findAll()).thenReturn(visitations);

        List<Visitation> visitationList = visitationService.findAll();
        assertThat(visitationList.size()).isNotZero();
    }

    @Test
    void findById() {
        when(visitationRepository.findById(anyLong())).thenReturn(Optional.of(visitation));
        Visitation visitation = visitationService.findById(ID);
        assertNotNull(visitation);
    }

    @Test
    void findByIdNotFound() {
        when(visitationRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(VisitationNotFoundException.class, () -> visitationService.findById(ID));
    }

    @Test
    void save() {
        when(visitationRepository.save(any(Visitation.class))).thenReturn(visitation);

        Visitation savedVisitation = visitationService.save(visitation);
        assertNotNull(savedVisitation);

        verify(visitationRepository).save(any(Visitation.class));
    }

    @Test
    void delete() {
        visitationService.delete(visitation);
        verify(visitationRepository).delete(any(Visitation.class));
    }

    @Test
    void deleteById() {
        visitationService.deleteById(ID);
        verify(visitationRepository).deleteById(anyLong());
    }
}