package ru.feodorkek.dev.perfectcrud.mapper;

import ru.feodorkek.dev.perfectcrud.dto.model.TeamDto;
import ru.feodorkek.dev.perfectcrud.dto.response.TeamResponse;
import ru.feodorkek.dev.perfectcrud.model.Team;

public interface TeamMapper {

    TeamResponse toResponse(TeamDto dto);

    TeamDto toDto(Team team);

}
