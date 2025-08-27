package ru.feodorkek.dev.perfectcrud.dto.response;

import java.time.Instant;
import java.util.List;

public record WorkspaceResponse(
        long id,
        String name,
        Instant createdAt,
        Instant modifiedAt,
        List<TeamResponse> teams) {
}
