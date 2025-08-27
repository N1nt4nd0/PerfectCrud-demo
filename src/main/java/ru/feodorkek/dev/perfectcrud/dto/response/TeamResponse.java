package ru.feodorkek.dev.perfectcrud.dto.response;

import java.time.Instant;

public record TeamResponse(
        long id,
        long workspaceId,
        String name,
        Instant createdAt,
        Instant modifiedAt) {
}
