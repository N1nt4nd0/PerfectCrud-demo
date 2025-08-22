package ru.feodorkek.dev.perfectcrud.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateWorkspaceRequest(
        @Min(1) long id,
        @NotBlank @Size(min = 1, max = 30) String name) {
}