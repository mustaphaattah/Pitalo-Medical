package pitalo.domain.Staff;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;


@Data
@SuperBuilder
@Entity
@NoArgsConstructor
public class Doctor extends Staff {
}
