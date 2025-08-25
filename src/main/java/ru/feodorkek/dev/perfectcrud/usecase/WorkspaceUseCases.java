package ru.feodorkek.dev.perfectcrud.usecase;

import ru.feodorkek.dev.perfectcrud.dto.response.TeamResponse;
import ru.feodorkek.dev.perfectcrud.dto.response.WorkspaceResponse;

import java.util.List;

public interface WorkspaceUseCases {

    WorkspaceResponse createWorkspace(String workspaceName);

    WorkspaceResponse updateWorkspace(long workspaceId, String newName);

    List<WorkspaceResponse> getWorkspaces();

    void deleteWorkspace(long workspaceId);

    TeamResponse createTeam(long workspaceId, String teamName);

    TeamResponse updateTeam(long teamId, String newName);

    void deleteTeam(long teamId);

}
