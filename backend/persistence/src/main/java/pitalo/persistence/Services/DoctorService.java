package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Staff.Doctor;
import pitalo.persistence.Repositories.DoctorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService implements CrudService<Doctor, Long> {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        doctorRepository
            .findAll()
            .forEach(doctors::add);
        return doctors;
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void delete(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }
}
