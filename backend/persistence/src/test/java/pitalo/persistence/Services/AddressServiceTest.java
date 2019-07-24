package pitalo.persistence.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pitalo.domain.Address;
import pitalo.persistence.Repositories.AddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    AddressService addressService;

    Address address;
    static final Long ID = 2L;

    @BeforeEach
    void setUp() {
        address = Address
            .builder()
            .id(ID)
            .build();
    }

    @Test
    void findAll() {
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);

        when(addressRepository.findAll()).thenReturn(addressList);
        List<Address> addresses = addressService.findAll();

        assertThat(addresses).isNotEmpty();
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(addressRepository.findById(anyLong())).thenReturn(Optional.of(address));
        Address address = addressService.findById(ID);
        assertNotNull(address);
    }

    @Test
    void findByIdNotFound() {
        when(addressRepository.findById(anyLong())).thenReturn(Optional.empty());
        Address address = addressService.findById(ID);
        assertNull(address);
    }

    @Test
    void save() {
        when(addressRepository.save(any(Address.class))).thenReturn(address);
        Address savedAddress = addressService.save(address);
        assertNotNull(savedAddress);
        verify(addressRepository).save(any(Address.class));
    }

    @Test
    void delete() {
        addressService.delete(address);
        verify(addressRepository, times(1)).delete(any(Address.class));
    }

    @Test
    void deleteById() {
        addressService.deleteById(ID);
        verify(addressRepository, times(1)).deleteById(anyLong());
    }
}