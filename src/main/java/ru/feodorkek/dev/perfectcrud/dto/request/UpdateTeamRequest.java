package ru.feodorkek.dev.perfectcrud.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateTeamRequest(
        @Min(1) long teamId,
        @NotBlank @Size(min = 1, max = 30) String newName) {
}
