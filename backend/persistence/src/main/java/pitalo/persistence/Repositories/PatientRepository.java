package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Patient.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    List<Patient> findAllByFirstNameStartingWith(String firstName);
    List<Patient> findAllByLastNameStartingWith(String lastName);
    List<Patient> findAllByHealthNumberStartingWith(String healthNumber);
}
