package ru.feodorkek.dev.perfectcrud.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.feodorkek.dev.perfectcrud.dto.model.TeamDto;
import ru.feodorkek.dev.perfectcrud.dto.model.WorkspaceDto;
import ru.feodorkek.dev.perfectcrud.dto.response.WorkspaceResponse;
import ru.feodorkek.dev.perfectcrud.model.Workspace;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkspaceMapperImpl implements WorkspaceMapper {

    private final TeamMapper teamMapper;

    @Override
    public WorkspaceResponse toResponse(final WorkspaceDto dto, final List<TeamDto> teamDtoList) {
        return new WorkspaceResponse(dto.id(), dto.name(), dto.createdAt(),
                dto.modifiedAt(), teamDtoList.stream().map(teamMapper::toResponse).toList());
    }

    @Override
    public WorkspaceDto toDto(final Workspace workspace) {
        return new WorkspaceDto(workspace.getId(), workspace.getName(),
                workspace.getCreatedAt(), workspace.getModifiedAt());
    }

}
