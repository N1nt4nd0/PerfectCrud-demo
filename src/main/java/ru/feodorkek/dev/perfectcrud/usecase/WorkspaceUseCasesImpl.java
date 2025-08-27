package ru.feodorkek.dev.perfectcrud.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.feodorkek.dev.perfectcrud.dto.model.TeamDto;
import ru.feodorkek.dev.perfectcrud.dto.model.WorkspaceDto;
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
    public WorkspaceResponse createWorkspace(final String workspaceName) {
        return workspaceMapper.toResponse(workspaceService.createWorkspace(workspaceName), List.of());
    }

    @Override
    @Transactional
    public WorkspaceResponse updateWorkspace(final long workspaceId, final String newName) {
        final var workspace = workspaceService.updateWorkspaceById(workspaceId, newName);
        final var teams = teamService.getTeamsByWorkspaceId(workspace.id());
        return workspaceMapper.toResponse(workspace, teams);
    }

    @SuppressWarnings("PMD.DataflowAnomalyAnalysis")
    @Override
    @Transactional(readOnly = true)
    public List<WorkspaceResponse> getWorkspaces() {
        final var workspaces = workspaceService.getAllWorkspaces();
        if (workspaces.isEmpty()) {
            return List.of();
        }
        final var workspacesIds = workspaces.stream()
                .map(WorkspaceDto::id).toList();
        final var teamsByWorkspace = teamService.getTeamsByWorkspaceIds(workspacesIds).stream()
                .collect(Collectors.groupingBy(TeamDto::workspaceId));
        return workspaces.stream()
                .map(ws -> workspaceMapper.toResponse(ws, teamsByWorkspace.getOrDefault(ws.id(), List.of())))
                .toList();
    }

    @Override
    @Transactional
    public void deleteWorkspace(final long workspaceId) {
        workspaceService.deleteWorkspaceById(workspaceId);
    }

    @Override
    @Transactional
    public TeamResponse createTeam(final long workspaceId, final String teamName) {
        final var workspace = workspaceService.getWorkspaceById(workspaceId);
        return teamMapper.toResponse(teamService.createTeam(workspace.id(), teamName));
    }

    @Override
    @Transactional
    public TeamResponse updateTeam(final long teamId, final String newName) {
        final var team = teamService.updateTeamById(teamId, newName);
        return teamMapper.toResponse(team);
    }

    @Override
    @Transactional
    public void deleteTeam(final long teamId) {
        teamService.deleteTeamById(teamId);
    }

}
