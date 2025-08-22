package ru.feodorkek.dev.perfectcrud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.feodorkek.dev.perfectcrud.dto.response.ExceptionResponse;
import ru.feodorkek.dev.perfectcrud.exception.NotFoundException;

@Slf4j
@RestControllerAdvice
public class RestControllerAdviceConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(
            final MethodArgumentNotValidException exception) {
        log.warn("Validation exception occurred: {}", exception.getMessage());
        final var message = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> String.format("%s: %s", error.getField(), error.getDefaultMessage()))
                .reduce((msg1, msg2) -> String.format("%s, %s", msg1, msg2))
                .orElse("Bad request arguments");
        return ResponseEntity.badRequest()
                .body(new ExceptionResponse(MethodArgumentNotValidException.class.getSimpleName(), message));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(final NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse("NotFoundException", exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleGenericException(final Exception exception) {
        final var exceptionType = exception.getClass().getSimpleName();
        log.error("RestController exception occurred: [{}]: {}", exceptionType, exception.getMessage());
        return ResponseEntity.internalServerError()
                .body(new ExceptionResponse(exceptionType, exception.getMessage()));
    }

}
