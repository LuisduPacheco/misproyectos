CREATE DATABASE bdjuego;
USE bdjuego;

CREATE TABLE rol_usuario(
	id_rol_usuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	tipo_usuario INT NOT NULL,
	descripcion_rol_usuario VARCHAR (25) NOT NULL	
); 

#nombre rol, puede ser 1 Administrador, 2 avanzado, 3 intermedio, 4 principiante 
INSERT INTO rol_usuario(tipo_usuario,descripcion_rol_usuario )
VALUES 
(1, 'Administrador'),
(2, 'Avanzado'),
(3, 'Intermedio'),
(4, 'Principiante');

SELECT * FROM bdjuego.rol_usuario
ALTER TABLE bdjuego.rol_usuario AUTO_INCREMENT = 1;
TRUNCATE TABLE rol_usuario;

CREATE TABLE usuario(
	id_usuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nombre_usuario VARCHAR(25) NOT NULL,
	apellido_usuario VARCHAR(25) NOT NULL,
	edad_usuario INT NOT NULL,
	username VARCHAR(25) NOT NULL, 
	contrasenia VARCHAR(25) NOT NULL, 
	id_rol_usuario_fk INT NOT NULL 
);

INSERT INTO usuario(nombre_usuario, apellido_usuario, edad_usuario, username, contrasenia, id_rol_usuario_fk)
VALUES ('Luis', 'De León', 25, 'luisdel', '123', 1);

INSERT INTO usuario (nombre_usuario, apellido_usuario, edad_usuario, username, contrasenia, id_rol_usuario_fk) VALUES
                        ('u.getNombreUsuario()', 'u.getApellidoUsuario()', 15, '"u.getUserName()', 'u.getContrasenia()', 1);

SELECT u.id_usuario, u.nombre_usuario, u.apellido_usuario, u.edad_usuario, u.username, u.contrasenia, u.id_rol_usuario_fk
FROM bdjuego.usuario u;


SELECT * FROM bdjuego.usuario;
ALTER TABLE bdjuego.usuario AUTO_INCREMENT = 1
TRUNCATE TABLE usuario;

#RELACION ROL_USUARIO, USUARIOS
ALTER TABLE bdjuego.usuario ADD CONSTRAINT FK1 FOREIGN KEY (id_rol_usuario_fk)
REFERENCES bdjuego.rol_usuario(id_rol_usuario);

SELECT 
r.id_rol_usuario, r.descripcion_rol_usuario,
u.nombre_usuario, u.apellido_usuario, u.edad_usuario, u.username, u.contrasenia
FROM bdjuego.rol_usuario r
INNER JOIN bdjuego.usuario u 

SELECT id_usuario, nombre_usuario, apellido_usuario,edad_usuario, username, contrasenia, id_rol_usuario_fk
FROM bdjuego.usuario;

#PREGUNTAS Y RESPUESTAS PARA EL NIVEL INTERMEDIO
CREATE TABLE preguntas(
id_pregunta INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
pregunta VARCHAR (100) NOT NULL 
);

INSERT INTO preguntas(pregunta)
VALUES 	('pregunta vacía'),
			('Primer presidente popularmente electoen Guatemala: '),
			('¿En que año fué la revolución de Octubre, en Guatemala?'),
			('¿Quién obtuvo el Premio Nobel de literatura?'),
			('¿Año de la firma de Independencia?'),
			('¿Lugar con las mayores construcciones Mayas en Guatemala?'),
			('¿Primer medallista olimpico para Guatemala?');

SELECT * FROM bdjuego.preguntas;
TRUNCATE TABLE preguntas;
DROP TABLE bdjuego.preguntas;

CREATE TABLE respuestas(
	id_respuesta INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	respuesta VARCHAR (25) NOT NULL,
	id_pregunta_fk INT NOT NULL
);

INSERT INTO respuestas(respuesta, id_pregunta_fk)
VALUES('-', 1), 
		('Juan José Arevalo', 2),
		('1944', 3),
		('Miguel Angel Asturias', 4),
		('1821',5),
		('Tikal',6),
		('Erick Barrondo',7);
SELECT * FROM bdjuego.respuestas;
DROP TABLE bdjuego.respuestas;
DROP DATABASE bdjuego;
#RELACION Preguntas, respuestas
ALTER TABLE bdjuego.respuestas ADD CONSTRAINT FK2 FOREIGN KEY (id_pregunta_fk)
REFERENCES bdjuego.preguntas(id_pregunta);