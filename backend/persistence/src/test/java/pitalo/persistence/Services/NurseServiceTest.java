package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Staff.Nurse;
import pitalo.persistence.Repositories.NurseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NurseServiceTest {

    @Mock
    NurseRepository nurseRepository;

    @InjectMocks
    NurseService nurseService;

    Nurse nurse;
    static final Long ID = 4L;

    @BeforeEach
    void setUp() {
        nurse = Nurse
            .builder()
            .id(ID)
            .build();
    }

    @Test
    void findAll() {
        List<Nurse> nurseList = new ArrayList<>();
        nurseList.add(nurse);

        when(nurseRepository.findAll()).thenReturn(nurseList);
        List<Nurse> nurses = nurseService.findAll();

        assertThat(nurses.size()).isEqualTo(1);
        verify(nurseRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(nurseRepository.findById(anyLong())).thenReturn(Optional.of(nurse));
        Nurse nurse = nurseService.findById(ID);
        assertNotNull(nurse);
        verify(nurseRepository).findById(anyLong());
    }

    @Test
    void findByIdNotFound() {
        when(nurseRepository.findById(anyLong())).thenReturn(Optional.empty());
        Nurse nurse = nurseService.findById(ID);
        assertNull(nurse);
        verify(nurseRepository).findById(anyLong());
    }

    @Test
    void save() {
        when(nurseRepository.save(any(Nurse.class))).thenReturn(nurse);
        Nurse savedNurse = nurseService.save(nurse);

        assertNotNull(savedNurse);
        verify(nurseRepository, times(1)).save(any(Nurse.class));
    }

    @Test
    void delete() {
        nurseService.delete(nurse);
        verify(nurseRepository, times(1)).delete(any(Nurse.class));
    }

    @Test
    void deleteById() {
        nurseService.deleteById(ID);
        verify(nurseRepository, times(1)).deleteById(anyLong());
    }
}