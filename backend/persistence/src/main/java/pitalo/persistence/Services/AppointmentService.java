package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Visitation.VisitationType.Appointment;
import pitalo.persistence.Repositories.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService implements CrudService<Appointment, Long> {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> findAll() {
        List<Appointment> appointments = new ArrayList<>();
        appointmentRepository
            .findAll()
            .forEach(appointments::add);
        return appointments;
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }
}
