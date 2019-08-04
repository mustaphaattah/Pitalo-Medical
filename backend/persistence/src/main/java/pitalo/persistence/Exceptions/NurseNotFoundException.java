package pitalo.persistence.Exceptions;

public class NurseNotFoundException extends RuntimeException {

    public NurseNotFoundException(String message) {
        super(message);
    }
}
