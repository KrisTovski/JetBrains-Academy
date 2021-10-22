package engine;

import javax.management.openmbean.KeyAlreadyExistsException;

public class UsernameAlreadyTakenException extends KeyAlreadyExistsException {

    public UsernameAlreadyTakenException() {
        super();
    }

    public UsernameAlreadyTakenException(String message) {
        super(message);
    }
}
