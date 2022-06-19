CREATE DATABASE bdconector;
USE bdconector;

CREATE TABLE pais(
	id_pais INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nombre_pais VARCHAR(60) NOT NULL,
	capital_pais VARCHAR(60) NOT NULL, 
	poblacion_pais BIGINT NOT NULL,
	fecha_ingreso_pais DATE NOT NULL,
	fecha_actualiza_pais DATE  
);

SELECT * FROM bdconector.pais;
ALTER TABLE bdconector.pais AUTO_INCREMENT = 20220000;
TRUNCATE TABLE pais; 

SELECT 
		p.id_pais, 
		p.nombre_pais, 
		p.capital_pais, 
		p.poblacion_pais
FROM bdconector.pais p
