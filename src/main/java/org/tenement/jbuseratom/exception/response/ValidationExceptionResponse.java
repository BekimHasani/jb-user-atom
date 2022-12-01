package org.tenement.jbuseratom.exception.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
public class ValidationExceptionResponse {

    private int status;
    private LocalDateTime timestamp;
    private Map<String, String> errors;

    public ValidationExceptionResponse(HttpStatus status, Map<String,String> errors) {
        this.status = status.value();
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }

}
