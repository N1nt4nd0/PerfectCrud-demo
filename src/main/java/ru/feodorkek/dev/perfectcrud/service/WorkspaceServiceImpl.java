package ru.feodorkek.dev.perfectcrud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.feodorkek.dev.perfectcrud.dto.model.WorkspaceDto;
import ru.feodorkek.dev.perfectcrud.exception.NotFoundException;
import ru.feodorkek.dev.perfectcrud.mapper.WorkspaceMapper;
import ru.feodorkek.dev.perfectcrud.model.Workspace;
import ru.feodorkek.dev.perfectcrud.repository.WorkspaceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceRepository repository;
    private final WorkspaceMapper mapper;

    @Override
    @Transactional
    public WorkspaceDto createWorkspace(final String name) {
        return mapper.toDto(repository.save(new Workspace(name)));
    }

    @Override
    @Transactional
    public WorkspaceDto updateWorkspaceById(final long id, final String name) {
        final var workspace = findByIdOrThrow(id);
        workspace.setName(name);
        return mapper.toDto(repository.saveAndFlush(workspace));
    }

    @Override
    @Transactional(readOnly = true)
    public WorkspaceDto getWorkspaceById(final long id) {
        return mapper.toDto(findByIdOrThrow(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkspaceDto> getAllWorkspaces() {
        return repository.findAllByOrderByCreatedAtAsc().stream()
                .map(mapper::toDto).toList();
    }

    @Override
    @Transactional
    public void deleteWorkspaceById(final long id) {
        repository.delete(findByIdOrThrow(id));
    }

    private Workspace findByIdOrThrow(final long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Workspace not found"));
    }

}
