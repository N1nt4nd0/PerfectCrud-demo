package ru.feodorkek.dev.perfectcrud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.feodorkek.dev.perfectcrud.dto.model.TeamDto;
import ru.feodorkek.dev.perfectcrud.dto.response.TeamResponse;
import ru.feodorkek.dev.perfectcrud.model.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {

    TeamResponse toResponse(TeamDto dto);

    TeamDto toDto(Team team);

}
