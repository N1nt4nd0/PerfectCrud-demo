package ru.feodorkek.dev.perfectcrud.exception;

import lombok.experimental.StandardException;

import java.io.Serial;

@StandardException
public class NotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

}
