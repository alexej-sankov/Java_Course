package exception;

import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class SomeCitiesNotFoundException extends Exception{

    public SomeCitiesNotFoundException(String message) {
        super(message);
    }
}
