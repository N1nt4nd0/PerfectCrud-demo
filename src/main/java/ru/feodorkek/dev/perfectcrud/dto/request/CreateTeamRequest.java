package ru.feodorkek.dev.perfectcrud.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTeamRequest(
        @Min(1) long workspaceId,
        @NotBlank @Size(min = 1, max = 30) String name) {
}
