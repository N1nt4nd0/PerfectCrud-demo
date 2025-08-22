package ru.feodorkek.dev.perfectcrud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.feodorkek.dev.perfectcrud.dto.model.TeamDto;
import ru.feodorkek.dev.perfectcrud.exception.NotFoundException;
import ru.feodorkek.dev.perfectcrud.mapper.TeamMapper;
import ru.feodorkek.dev.perfectcrud.model.Team;
import ru.feodorkek.dev.perfectcrud.repository.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repository;
    private final TeamMapper mapper;

    @Override
    @Transactional
    public TeamDto createTeam(final long workspaceId, final String name) {
        return mapper.toDto(repository.saveAndFlush(new Team(workspaceId, name)));
    }

    @Override
    @Transactional
    public TeamDto updateTeamById(final long id, final String name) {
        final var team = findByIdOrThrow(id);
        team.setName(name);
        return mapper.toDto(repository.saveAndFlush(team));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeamDto> getTeamsByWorkspaceId(final long workspaceId) {
        return repository.findAllByWorkspaceIdOrderByCreatedAtAsc(workspaceId).stream()
                .map(mapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeamDto> getTeamsByWorkspaceIds(final List<Long> workspaceIds) {
        return repository.findAllByWorkspaceIdInOrderByCreatedAtAsc(workspaceIds).stream()
                .map(mapper::toDto).toList();
    }

    @Override
    @Transactional
    public void deleteTeamById(final long id) {
        repository.delete(findByIdOrThrow(id));
    }

    private Team findByIdOrThrow(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Team not found"));
    }

}
