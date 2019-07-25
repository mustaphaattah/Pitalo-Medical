package pitalo.domain.Staff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Specialty extends BaseEntity {

    @NotEmpty(message = "Specialty cannot be empty")
    private String name;

    @Builder
    public Specialty(Long id, String name) {
        super(id);
        this.name = name;
    }
}
