package pitalo.domain.Visitation.VisitationType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pitalo.domain.Visitation.Visitation;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class VisitationType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(mappedBy = "visitationType")
    @JsonIgnore
    private Visitation visitation;

    @Column(name = "type", updatable = false)
    private String type;

}
