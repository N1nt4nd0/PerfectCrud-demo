package ru.feodorkek.dev.perfectcrud.mapper;

import ru.feodorkek.dev.perfectcrud.dto.model.WorkspaceDto;
import ru.feodorkek.dev.perfectcrud.dto.response.WorkspaceResponse;
import ru.feodorkek.dev.perfectcrud.model.Workspace;

public interface WorkspaceMapper {

    WorkspaceResponse toResponse(WorkspaceDto workspaceDto);

    WorkspaceDto toDto(Workspace workspace);

}
