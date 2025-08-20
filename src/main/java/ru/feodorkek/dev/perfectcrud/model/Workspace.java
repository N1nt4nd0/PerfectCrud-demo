package ru.feodorkek.dev.perfectcrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Workspace extends AuditableEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

}
