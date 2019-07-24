package pitalo.persistence.Services;

import org.springframework.stereotype.Service;
import pitalo.domain.Address;
import pitalo.persistence.Repositories.AddressRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService implements CrudService<Address, Long> {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>();
        addressRepository
            .findAll()
            .forEach(addresses::add);
        return addresses;
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
