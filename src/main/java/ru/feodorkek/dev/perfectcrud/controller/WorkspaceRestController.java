package ru.feodorkek.dev.perfectcrud.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.feodorkek.dev.perfectcrud.dto.request.CreateTeamRequest;
import ru.feodorkek.dev.perfectcrud.dto.request.CreateWorkspaceRequest;
import ru.feodorkek.dev.perfectcrud.dto.request.UpdateTeamRequest;
import ru.feodorkek.dev.perfectcrud.dto.request.UpdateWorkspaceRequest;
import ru.feodorkek.dev.perfectcrud.dto.response.TeamResponse;
import ru.feodorkek.dev.perfectcrud.dto.response.WorkspaceResponse;
import ru.feodorkek.dev.perfectcrud.usecase.WorkspaceUseCases;

import java.util.List;

@Tag(name = "Workspace rest controller")
@Validated
@RestController
@RequiredArgsConstructor
public class WorkspaceRestController {

    private final WorkspaceUseCases useCases;

    @Operation(summary = "create workspace")
    @PostMapping("${rest-api.endpoints.workspace-create}")
    public ResponseEntity<WorkspaceResponse> createWorkspace(@RequestBody @Valid final CreateWorkspaceRequest request) {
        return ResponseEntity.ok(useCases.createWorkspace(request));
    }

    @Operation(summary = "update workspace")
    @PatchMapping("${rest-api.endpoints.workspace-update}")
    public ResponseEntity<WorkspaceResponse> updateWorkspace(@RequestBody @Valid final UpdateWorkspaceRequest request) {
        return ResponseEntity.ok(useCases.updateWorkspace(request));
    }

    @Operation(summary = "delete workspace")
    @DeleteMapping("${rest-api.endpoints.workspace-delete}")
    public ResponseEntity<Void> deleteWorkspace(@RequestParam @Min(1) final long workspaceId) {
        useCases.deleteWorkspace(workspaceId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "get workspaces")
    @GetMapping("${rest-api.endpoints.workspace-list}")
    public ResponseEntity<List<WorkspaceResponse>> getWorkspaces() {
        return ResponseEntity.ok(useCases.getWorkspaces());
    }

    @Operation(summary = "create team")
    @PostMapping("${rest-api.endpoints.team-create}")
    public ResponseEntity<TeamResponse> createTeam(@RequestBody @Valid final CreateTeamRequest request) {
        return ResponseEntity.ok(useCases.createTeam(request));
    }

    @Operation(summary = "update team")
    @PatchMapping("${rest-api.endpoints.team-update}")
    public ResponseEntity<TeamResponse> updateTeam(@RequestBody @Valid final UpdateTeamRequest request) {
        return ResponseEntity.ok(useCases.updateTeam(request));
    }

    @Operation(summary = "delete team")
    @DeleteMapping("${rest-api.endpoints.team-delete}")
    public ResponseEntity<Void> deleteTeam(@RequestParam @Min(1) final long id) {
        useCases.deleteTeam(id);
        return ResponseEntity.ok().build();
    }

}
