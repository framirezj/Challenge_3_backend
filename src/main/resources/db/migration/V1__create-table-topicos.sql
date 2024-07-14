create table topicos(

    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    activo tinyint,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);