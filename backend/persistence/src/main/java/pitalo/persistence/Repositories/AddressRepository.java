package pitalo.persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pitalo.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
