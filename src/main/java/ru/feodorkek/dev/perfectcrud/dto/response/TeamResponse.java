package ru.feodorkek.dev.perfectcrud.dto.response;

import java.time.Instant;

public record TeamResponse(long id, String name, Instant createdAt, Instant modifiedAt) {
}
