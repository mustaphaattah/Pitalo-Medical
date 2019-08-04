package pitalo.domain.Visitation.VisitationType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "subType"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Appointment.class),
    @JsonSubTypes.Type(value = Emergency.class),
    @JsonSubTypes.Type(value = WalkIn.class)
})
public abstract class VisitationType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(mappedBy = "visitationType")
    @JsonIgnore
    private Visitation visitation;

    @Column(name = "type")
    private String type;

}
