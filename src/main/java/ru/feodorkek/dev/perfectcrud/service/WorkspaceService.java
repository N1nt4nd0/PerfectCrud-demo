package ru.feodorkek.dev.perfectcrud.service;

import ru.feodorkek.dev.perfectcrud.dto.model.WorkspaceDto;

import java.util.List;

public interface WorkspaceService {

    WorkspaceDto createWorkspace(String name);

    WorkspaceDto updateWorkspaceById(long id, String name);

    WorkspaceDto getWorkspaceById(long id);

    List<WorkspaceDto> getAllWorkspaces();

    void deleteWorkspaceById(long id);

}
