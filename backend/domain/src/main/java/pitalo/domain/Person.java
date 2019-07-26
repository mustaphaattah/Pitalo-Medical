package pitalo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "FirstName is required")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "LastName is required")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "sex")
    @NotNull
    private Sex sex;

    @Column(name = "registration_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @PrePersist
    protected void setSex() {
        if (this.sex.name().equals("Male")) {
            this.sex = Sex.Male;
        } else if (this.sex.name().equals("Female")) {
            this.sex = Sex.Female;
        } else {
            this.sex = Sex.Not_Given;
        }
    }

    @PrePersist
    protected  void setRegistrationDate() {
        this.registrationDate = LocalDateTime.now();
    }
}
