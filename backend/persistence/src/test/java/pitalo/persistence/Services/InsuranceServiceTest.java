package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Patient.Insurance;
import pitalo.persistence.Repositories.InsuranceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InsuranceServiceTest {

    @Mock
    InsuranceRepository insuranceRepository;

    @InjectMocks
    InsuranceService insuranceService;

    Insurance insurance;
    static final Long ID = 2L;

    @BeforeEach
    void setUp() {
        insurance = Insurance
            .builder()
            .id(ID)
            .build();
    }

    @Test
    void findAll() {
        List<Insurance> insurances = new ArrayList<>();
        insurances.add(insurance);

        when(insuranceRepository.findAll()).thenReturn(insurances);
        List<Insurance> insuranceList = insuranceService.findAll();

        assertThat(insuranceList).isNotEmpty();
        verify(insuranceRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(insuranceRepository.findById(anyLong())).thenReturn(Optional.of(insurance));
        Insurance insurance = insuranceService.findById(ID);
        assertNotNull(insurance);
    }

    @Test
    void findByIdNotFound() {
        when(insuranceRepository.findById(anyLong())).thenReturn(Optional.empty());
        Insurance insurance = insuranceService.findById(ID);
        assertNull(insurance);
    }

    @Test
    void save() {
        when(insuranceRepository.save(any(Insurance.class))).thenReturn(insurance);

        Insurance savedInsurance = insuranceService.save(insurance);
        assertNotNull(savedInsurance);
        verify(insuranceRepository, times(1)).save(any(Insurance.class));
    }

    @Test
    void delete() {
        insuranceService.delete(insurance);
        verify(insuranceRepository, times(1)).delete(insurance);
    }

    @Test
    void deleteById() {
        insuranceService.deleteById(ID);
        verify(insuranceRepository, times(1)).deleteById(anyLong());
    }
}