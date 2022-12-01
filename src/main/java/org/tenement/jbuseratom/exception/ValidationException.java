package org.tenement.jbuseratom.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 100000L;

    public ValidationException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }

    @Getter
    @Setter
    private Map<String, String> errors;

}
