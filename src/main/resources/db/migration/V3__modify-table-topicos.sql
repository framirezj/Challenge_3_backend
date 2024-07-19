
#modificaciones

ALTER TABLE topicos CHANGE autor autor_id BIGINT;

ALTER TABLE topicos
    ADD CONSTRAINT fk_autor
        FOREIGN KEY (autor_id) REFERENCES usuarios(id);

ALTER TABLE topicos MODIFY COLUMN activo tinyint DEFAULT 1;