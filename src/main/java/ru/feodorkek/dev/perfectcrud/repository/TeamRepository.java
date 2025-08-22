package ru.feodorkek.dev.perfectcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.feodorkek.dev.perfectcrud.model.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findAllByWorkspaceIdOrderByCreatedAtAsc(long workspaceId);

    List<Team> findAllByWorkspaceIdInOrderByCreatedAtAsc(List<Long> workspaceIds);

}
