package ru.feodorkek.dev.perfectcrud.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.feodorkek.dev.perfectcrud.dto.model.TeamDto;
import ru.feodorkek.dev.perfectcrud.dto.model.WorkspaceDto;
import ru.feodorkek.dev.perfectcrud.dto.request.CreateTeamRequest;
import ru.feodorkek.dev.perfectcrud.dto.request.CreateWorkspaceRequest;
import ru.feodorkek.dev.perfectcrud.dto.request.UpdateTeamRequest;
import ru.feodorkek.dev.perfectcrud.dto.request.UpdateWorkspaceRequest;
import ru.feodorkek.dev.perfectcrud.dto.response.TeamResponse;
import ru.feodorkek.dev.perfectcrud.dto.response.WorkspaceResponse;
import ru.feodorkek.dev.perfectcrud.mapper.TeamMapper;
import ru.feodorkek.dev.perfectcrud.mapper.WorkspaceMapper;
import ru.feodorkek.dev.perfectcrud.service.TeamService;
import ru.feodorkek.dev.perfectcrud.service.WorkspaceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkspaceUseCasesImpl implements WorkspaceUseCases {

    private final WorkspaceService workspaceService;
    private final WorkspaceMapper workspaceMapper;
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @Override
    @Transactional
    public WorkspaceResponse createWorkspace(final CreateWorkspaceRequest request) {
        return workspaceMapper.toResponse(workspaceService.createWorkspace(request.name()), List.of());
    }

    @Override
    @Transactional
    public WorkspaceResponse updateWorkspace(final UpdateWorkspaceRequest request) {
        final var workspace = workspaceService.updateWorkspaceById(request.id(), request.name());
        final var teams = teamService.getTeamsByWorkspaceId(workspace.id());
        return workspaceMapper.toResponse(workspace, teams);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkspaceResponse> getWorkspaces() {
        final var workspaces = workspaceService.getAllWorkspaces();
        if (workspaces.isEmpty()) {
            return List.of();
        }
        final var workspacesIds = workspaces.stream().map(WorkspaceDto::id).toList();
        final var teams = teamService.getTeamsByWorkspaceIds(workspacesIds);
        final var teamsByWorkspace = teams.stream().collect(Collectors.groupingBy(TeamDto::workspaceId));
        return workspaces.stream()
                .map(ws -> workspaceMapper.toResponse(ws, teamsByWorkspace.getOrDefault(ws.id(), List.of())))
                .toList();
    }

    @Override
    @Transactional
    public void deleteWorkspace(final long id) {
        workspaceService.deleteWorkspaceById(id);
    }

    @Override
    @Transactional
    public TeamResponse createTeam(final CreateTeamRequest request) {
        final var workspace = workspaceService.getWorkspaceById(request.workspaceId());
        return teamMapper.toResponse(teamService.createTeam(workspace.id(), request.name()));
    }

    @Override
    @Transactional
    public TeamResponse updateTeam(final UpdateTeamRequest request) {
        final var team = teamService.updateTeamById(request.id(), request.name());
        return teamMapper.toResponse(team);
    }

    @Override
    @Transactional
    public void deleteTeam(final long id) {
        teamService.deleteTeamById(id);
    }

}
