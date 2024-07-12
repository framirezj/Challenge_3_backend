create table topicos(

    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    activo TINYINT(1) NOT NULL DEFAULT 1,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);