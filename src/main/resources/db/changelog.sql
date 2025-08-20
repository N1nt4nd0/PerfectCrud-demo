--liquibase formatted sql

--changeset author-example@gmail.com:create-workspace-table
CREATE TABLE public.workspace (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    modified_at TIMESTAMP WITH TIME ZONE
);

--changeset author-example@gmail.com:create-team-table
CREATE TABLE public.team (
    id BIGSERIAL PRIMARY KEY,
    workspace_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    modified_at TIMESTAMP WITH TIME ZONE,
    CONSTRAINT fk_team_workspace FOREIGN KEY (workspace_id) REFERENCES public.workspace(id) ON DELETE CASCADE
);