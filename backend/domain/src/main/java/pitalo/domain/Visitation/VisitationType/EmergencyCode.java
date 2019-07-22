package pitalo.domain.Visitation.VisitationType;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public enum EmergencyCode {
    HIGH_IMMEDIATE("99281"),
    HIGH_URGENT("99282"),
    MODERATE("99283"),
    LOW_SEVERITY("99284"),
    MINOR("99285");

    private String code;

    EmergencyCode(String code) {
        this.code = code;
    }
}
