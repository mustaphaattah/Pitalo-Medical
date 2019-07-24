package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Staff.Specialty;
import pitalo.persistence.Repositories.SpecialtyRepository;

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
class SpecialtyServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialtyService specialtyService;

    Specialty specialty;
    static final Long ID = 3L;
    static final String NAME = "Cardiology";

    @BeforeEach
    void setUp() {
        specialty = Specialty
            .builder()
            .id(ID)
            .name(NAME)
            .build();
    }

    @Test
    void findAll() {
        List<Specialty> specialties = new ArrayList<>();
        specialties.add(specialty);

        when(specialtyRepository.findAll()).thenReturn(specialties);
        List<Specialty> allSpecialties = specialtyService.findAll();

        assertThat(allSpecialties.size()).isNotZero();
        verify(specialtyRepository).findAll();
    }

    @Test
    void findById() {
        when(specialtyRepository.findById(anyLong())).thenReturn(Optional.of(specialty));
        Specialty foundSpecialty = specialtyService.findById(ID);
        assertNotNull(foundSpecialty);
    }

    @Test
    void findByIdNotFound() {
        when(specialtyRepository.findById(anyLong())).thenReturn(Optional.empty());
        Specialty foundSpecialty = specialtyService.findById(ID);
        assertNull(foundSpecialty);
    }

    @Test
    void save() {
        when(specialtyRepository.save(any(Specialty.class))).thenReturn(specialty);
        Specialty savedSpecialty = specialtyService.save(specialty);

        assertNotNull(savedSpecialty);
        verify(specialtyRepository).save(any(Specialty.class));
    }

    @Test
    void delete() {
        specialtyService.delete(specialty);
        verify(specialtyRepository, times(1)).delete(any(Specialty.class));
    }

    @Test
    void deleteById() {
        specialtyService.deleteById(ID);
        verify(specialtyRepository, times(1)).deleteById(anyLong());
    }
}