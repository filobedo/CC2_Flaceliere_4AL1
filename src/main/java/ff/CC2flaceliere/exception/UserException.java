package ff.CC2flaceliere.exception;

import org.springframework.http.HttpStatus;

import java.security.InvalidParameterException;

public class UserException extends Throwable {
    public UserException(String message) {
        super (message);
    }
}
