package ru.feodorkek.dev.perfectcrud.usecase;

import ru.feodorkek.dev.perfectcrud.dto.request.CreateTeamRequest;
import ru.feodorkek.dev.perfectcrud.dto.request.CreateWorkspaceRequest;
import ru.feodorkek.dev.perfectcrud.dto.request.UpdateTeamRequest;
import ru.feodorkek.dev.perfectcrud.dto.request.UpdateWorkspaceRequest;
import ru.feodorkek.dev.perfectcrud.dto.response.TeamResponse;
import ru.feodorkek.dev.perfectcrud.dto.response.WorkspaceResponse;

import java.util.List;

public interface WorkspaceUseCases {

    WorkspaceResponse createWorkspace(CreateWorkspaceRequest request);

    WorkspaceResponse updateWorkspace(UpdateWorkspaceRequest request);

    List<WorkspaceResponse> getWorkspaces();

    void deleteWorkspace(long id);

    TeamResponse createTeam(CreateTeamRequest request);

    TeamResponse updateTeam(UpdateTeamRequest request);

    void deleteTeam(long id);

}
