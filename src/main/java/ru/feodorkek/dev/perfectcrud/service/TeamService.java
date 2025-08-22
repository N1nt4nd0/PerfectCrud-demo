package ru.feodorkek.dev.perfectcrud.service;

import ru.feodorkek.dev.perfectcrud.dto.model.TeamDto;

import java.util.List;

public interface TeamService {

    TeamDto createTeam(long workspaceId, String name);

    TeamDto updateTeamById(long id, String name);

    List<TeamDto> getTeamsByWorkspaceId(long workspaceId);

    List<TeamDto> getTeamsByWorkspaceIds(List<Long> workspaceIds);

    void deleteTeamById(long id);

}
