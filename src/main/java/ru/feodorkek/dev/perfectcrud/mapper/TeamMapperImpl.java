package ru.feodorkek.dev.perfectcrud.mapper;

import org.springframework.stereotype.Component;
import ru.feodorkek.dev.perfectcrud.dto.model.TeamDto;
import ru.feodorkek.dev.perfectcrud.dto.response.TeamResponse;
import ru.feodorkek.dev.perfectcrud.model.Team;

@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamResponse toResponse(final TeamDto dto) {
        return new TeamResponse(dto.id(), dto.workspaceId(), dto.name(), dto.createdAt(), dto.modifiedAt());
    }

    @Override
    public TeamDto toDto(final Team team) {
        return new TeamDto(team.getId(), team.getWorkspaceId(),
                team.getName(), team.getCreatedAt(), team.getModifiedAt());
    }

}
