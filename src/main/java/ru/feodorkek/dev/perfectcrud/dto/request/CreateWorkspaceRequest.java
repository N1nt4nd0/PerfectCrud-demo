package ru.feodorkek.dev.perfectcrud.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateWorkspaceRequest(
        @NotBlank @Size(min = 1, max = 30) String name) {
}
