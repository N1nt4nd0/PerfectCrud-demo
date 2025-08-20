package ru.feodorkek.dev.perfectcrud.dto.model;

import java.time.Instant;
import java.util.List;

public record WorkspaceDto(long id, String name, Instant createdAt, Instant modifiedAt, List<TeamDto> teams) {
}
