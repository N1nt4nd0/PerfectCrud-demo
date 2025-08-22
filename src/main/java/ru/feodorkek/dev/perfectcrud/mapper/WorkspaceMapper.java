package ru.feodorkek.dev.perfectcrud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.feodorkek.dev.perfectcrud.dto.model.TeamDto;
import ru.feodorkek.dev.perfectcrud.dto.model.WorkspaceDto;
import ru.feodorkek.dev.perfectcrud.dto.response.WorkspaceResponse;
import ru.feodorkek.dev.perfectcrud.model.Workspace;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = TeamMapper.class)
public interface WorkspaceMapper {

    @Mapping(target = "teams", source = "teamDtoList")
    WorkspaceResponse toResponse(WorkspaceDto dto, List<TeamDto> teamDtoList);

    WorkspaceDto toDto(Workspace workspace);

}
