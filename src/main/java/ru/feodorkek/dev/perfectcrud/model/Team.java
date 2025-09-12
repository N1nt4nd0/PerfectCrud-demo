package ru.feodorkek.dev.perfectcrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "team", schema = "public")
@With
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @With(AccessLevel.NONE)
    private Long id;

    @Column(name = "workspace_id", nullable = false)
    private final long workspaceId;

    @Column(name = "name", nullable = false)
    private final String name;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @With(AccessLevel.NONE)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "modified_at", nullable = false)
    @With(AccessLevel.NONE)
    private Instant modifiedAt;

    public Team(final long workspaceId, final String name) {
        this.workspaceId = workspaceId;
        this.name = name;
    }

}
