package pitalo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "FirstName is required")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "LastName is required")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "sex")
    @NotNull
    private Sex sex;

    @Column(name = "registration_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @PrePersist
    protected void init() {

        this.registrationDate = LocalDateTime.now();
    }

}
