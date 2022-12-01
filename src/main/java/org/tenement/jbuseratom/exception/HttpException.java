package org.tenement.jbuseratom.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class HttpException extends RuntimeException{

    private static final long serialVersionUID = 100001L;

    @Getter
    private LocalDateTime timestamp;

    @Getter
    private HttpStatus httpStatus;

    @Getter
    private String message;
}
