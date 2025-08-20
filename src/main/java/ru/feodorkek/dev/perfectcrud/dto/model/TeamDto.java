package ru.feodorkek.dev.perfectcrud.dto.model;

import java.time.Instant;

public record TeamDto(long id, String name, Instant createdAt, Instant modifiedAt) {
}
