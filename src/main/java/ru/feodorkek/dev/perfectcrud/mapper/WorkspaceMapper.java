package ru.feodorkek.dev.perfectcrud.mapper;

import ru.feodorkek.dev.perfectcrud.dto.model.TeamDto;
import ru.feodorkek.dev.perfectcrud.dto.model.WorkspaceDto;
import ru.feodorkek.dev.perfectcrud.dto.response.WorkspaceResponse;
import ru.feodorkek.dev.perfectcrud.model.Workspace;

import java.util.List;

public interface WorkspaceMapper {

    WorkspaceResponse toResponse(WorkspaceDto dto, List<TeamDto> teamDtoList);

    WorkspaceDto toDto(Workspace workspace);

}
