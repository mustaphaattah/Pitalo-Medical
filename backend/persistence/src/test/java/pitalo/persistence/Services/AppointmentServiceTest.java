package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Visitation.VisitationType.Appointment;
import pitalo.persistence.Repositories.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

    @Mock
    AppointmentRepository appointmentRepository;

    @InjectMocks
    AppointmentService appointmentService;

    Appointment appointment;
    static final Long ID = 8L;

    @BeforeEach
    void setUp() {
        appointment = Appointment
            .builder()
            .id(ID)
            .build();
    }

    @Test
    void findAll() {
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment);

        when(appointmentRepository.findAll()).thenReturn(appointmentList);
        List<Appointment> appointments = appointmentService.findAll();

        assertThat(appointments.size()).isEqualTo(1);
        verify(appointmentRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(appointmentRepository.findById(anyLong())).thenReturn(Optional.of(appointment));
        Appointment appointment = appointmentService.findById(ID);
        assertNotNull(appointment);
    }

    @Test
    void findByIdNotFound() {
        when(appointmentRepository.findById(anyLong())).thenReturn(Optional.empty());
        Appointment appointment = appointmentService.findById(ID);
        assertNull(appointment);
    }

    @Test
    void save() {
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);
        Appointment savedAppointment = appointmentService.save(appointment);

        assertNotNull(savedAppointment);
        verify(appointmentRepository).save(any(Appointment.class));
    }

    @Test
    void delete() {
        appointmentService.delete(appointment);
        verify(appointmentRepository, times(1)).delete(any(Appointment.class));
    }

    @Test
    void deleteById() {
        appointmentService.deleteById(ID);
        verify(appointmentRepository).deleteById(anyLong());
    }
}