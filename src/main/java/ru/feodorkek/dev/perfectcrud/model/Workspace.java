package ru.feodorkek.dev.perfectcrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.feodorkek.dev.perfectcrud.model.base.AuditableEntity;

@Entity
@Table(name = "workspace", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Workspace extends AuditableEntity {

    @Column(name = "name", nullable = false)
    private String name;

}
