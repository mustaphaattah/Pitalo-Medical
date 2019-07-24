package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Staff.Doctor;
import pitalo.persistence.Repositories.DoctorRepository;

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
class DoctorServiceTest {

    @Mock
    DoctorRepository doctorRepository;

    @InjectMocks
    DoctorService doctorService;

    Doctor doctor;
    static final Long ID = 4L;

    @BeforeEach
    void setUp() {
        doctor = Doctor
            .builder()
            .id(ID)
            .build();
    }

    @Test
    void findAll() {
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(doctor);

        when(doctorRepository.findAll()).thenReturn(doctorList);
        List<Doctor> doctors = doctorService.findAll();

        assertThat(doctors).isNotEmpty();
        verify(doctorRepository).findAll();
    }

    @Test
    void findById() {
        when(doctorRepository.findById(anyLong())).thenReturn(Optional.of(doctor));
        Doctor doctor = doctorService.findById(ID);
        assertNotNull(doctor);
    }

    @Test
    void findByIdNotFound() {
        when(doctorRepository.findById(anyLong())).thenReturn(Optional.empty());
        Doctor doctor = doctorService.findById(ID);
        assertNull(doctor);
    }

    @Test
    void save() {
        when(doctorRepository.save(any(Doctor.class))).thenReturn(doctor);
        Doctor savedDoctor = doctorService.save(doctor);
        assertNotNull(savedDoctor);
        verify(doctorRepository, times(1)).save(any(Doctor.class));
    }

    @Test
    void delete() {
        doctorService.delete(doctor);
        verify(doctorRepository).delete(any(Doctor.class));
    }

    @Test
    void deleteById() {
        doctorService.deleteById(ID);
        verify(doctorRepository).deleteById(anyLong());
    }
}