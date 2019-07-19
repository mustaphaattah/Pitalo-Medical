package pitalo.domain.Visitation;

public enum BloodType {
    APOSITIVE ("A-positive"),
    ANEGATIVE ("A-negative"),
    BPOSITIVE ("B-positive"),
    BNEGATIVE ("B-negative"),
    ABPOSITIVE ("AB-positive"),
    ABNEGATIVE ("AB-negative"),
    OPOSITIVE ("O-positive"),
    ONEGATIVE ("O-negative");


    private final String value;

    BloodType(String value) {
        this.value = value;
    }

    private String value() {
        return this.value;
    }
}
