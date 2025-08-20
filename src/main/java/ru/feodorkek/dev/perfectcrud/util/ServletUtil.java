package ru.feodorkek.dev.perfectcrud.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import ru.feodorkek.dev.perfectcrud.dto.response.ExceptionResponse;

import java.io.IOException;

public final class ServletUtil {

    public static void sendError(final HttpServletResponse response,
                                 final int statusCode,
                                 final String exceptionType,
                                 final String message,
                                 final ObjectMapper objectMapper) throws IOException {
        final var exceptionResponse = new ExceptionResponse(exceptionType, message);
        response.setStatus(statusCode);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(exceptionResponse));
    }

    public static void sendError(final HttpServletResponse response,
                                 final int statusCode,
                                 final Exception exception,
                                 final ObjectMapper objectMapper) throws IOException {
        sendError(response, statusCode, exception.getClass().getSimpleName(), exception.getMessage(), objectMapper);
    }

}
