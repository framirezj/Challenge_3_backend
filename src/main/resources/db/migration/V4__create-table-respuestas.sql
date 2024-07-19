CREATE TABLE Respuesta (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           mensaje TEXT NOT NULL,
                           fecha_creacion datetime NOT NULL,
                           solucion tinyint default 0,
                           topico_id BIGINT,
                           autor_id BIGINT,
                           FOREIGN KEY (topico_id) REFERENCES topicos(id),
                           FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);