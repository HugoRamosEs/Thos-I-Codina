-- E03_Primeres-Passes-Joc

-- 1: Els punts obtinguts sempre seran positius, per tant, crea el domini dels nombres senceres positius.
CREATE DOMAIN nombres_positius AS INTEGER CHECK (VALUE > 0);

/* 2: Crea un tipus de dada en el que emmagatzemarem els punts que anem aconseguint, així com les possibles 
	  penalitzacions que podem rebre. */
CREATE TYPE punts AS (
	punts nombres_positius,
	penalitzacions nombres_positius
);

-- 3: Els jugadors només poden pertànyer a una de les categories: infantil, juvenil o sènior.
CREATE TYPE categoria_nom AS ENUM ('infantil', 'juvenil', 'sènior');

CREATE TYPE categoria AS (
	nom categoria_nom
);

-- 4: Necessitarem un tipus de dades de negoci que aglutina informació dels diferents jugadors.
CREATE TYPE jugador AS (
	nom VARCHAR(100),
	categoria categoria_nom,
	puntuacio punts
);

/* 5: Afegeix la següent informació a la base de dades:
	JUGADOR		CATEGORIA		PUNTUACIÓ		PENALITZACIÓ
	Anna		Infantil		12				2
	Diego		Sènior			6				1
	Luca		Juvenil			10				3
	Elena		Infantil		9				1
	Lucia		Peques			6				0
	Sonia		Infantil		8				-1

Què observes? 
Observo que no em deixa insertar ni a Lucia ni a Sonia. A Lucia no la puc insertar perque he definit que
el tipus categoria sigui un ENUM amb els valors (infantil, juvenil, sènior). D'altra banda, tampoc puc
insertar a Sonia perquè amb el domini del principi, he creat el tipus punts, indicant que no poden tenir
nombres negatius, només positius.*/

CREATE TABLE joc (
	id SERIAL PRIMARY KEY,
	jugador jugador
);

INSERT INTO joc (jugador) VALUES
	(ROW('Anna', 'infantil', ROW(12,2))),
	(ROW('Diego', 'sènior', ROW(6, 1))),
   	(ROW('Luca', 'juvenil', ROW(10, 3))),
 	(ROW('Elena', 'infantil', ROW(9, 1)));

-- Els trec perquè no deixa insertar-los.
    -- (ROW('Lucia', 'peques', ROW(6, 0))),
    -- (ROW('Sonia', 'infantil', ROW(8, -1)));

/* 6: Visualitza tots els resultats ordenats per categoria. 
En quin ordre apareixen?
Apareixen en ordre alfabetic. */

SELECT * FROM joc ORDER BY (jugador).categoria;

/* 7: Defineix una funció per obtenir la puntuació real d'un jugador. Reba com paràmetres un tipus compost 
	  (objecte) que conté els punt i penalització definit en el punt 2) i retorna un sencer que és el resultat 
      de restar els punts menys la penalització. Fes una prova de la funció amb SELECT nom_funcio( (3,1) ); */
CREATE FUNCTION obtenirPuntuacioRealJugador(_punts punts) RETURNS int AS 
$$
	BEGIN
		RETURN (_punts).punts - (_punts).penalitzacions;
	END;
$$ LANGUAGE plpgsql;

SELECT obtenirPuntuacioRealJugador((3,1));

-- 8: Visualitza una taula amb tres columnes: nom del jugador, punts que porta, puntuació real.
SELECT (jugador).nom as nom, (jugador).puntuacio as punts_que_porta, 
	obtenirPuntuacioRealJugador((jugador).puntuacio) as puntuacio_real
	FROM joc;

-- 9: Mostra el nom del jugador amb més punts per cada categoria.
SELECT DISTINCT ON ((jugador).categoria) (jugador).nom AS jugador FROM joc
ORDER BY (jugador).categoria, ((jugador).puntuacio).punts DESC;

-- 10: Mostra el nom del jugador amb més punts (independentment de la categoria)
SELECT (jugador).nom AS jugador FROM joc 
WHERE obtenirPuntuacioRealJugador((jugador).puntuacio) = 
    (SELECT MAX(obtenirPuntuacioRealJugador((jugador).puntuacio)) FROM joc);

/* 11: És correcte fer servir la següent sentència per donar el resultat de l'apartat 10)? Per què?  (Adapta jugador, 
	   resultado, puntuacion, puntos a la teva definició de tipus). SELECT jugador FROM resultado ORDER BY (puntuacion).puntos 
	   DESC LIMIT 1; 
No és correcte perquè et retorna el jugador amb la puntuació més alta de cada categoria, no de totes les categories. */

SELECT jugador FROM joc 
ORDER BY obtenirPuntuacioRealJugador((jugador).puntuacio) DESC 
LIMIT 1;

-- 12: Mostra el nom del jugador amb una puntuació de (6,1)
SELECT (jugador).nom AS jugador FROM joc 
WHERE ((jugador).puntuacio).punts = 6 AND ((jugador).puntuacio).penalitzacions = 1;

/* 13: Mostra el nom del jugador amb una puntuació de (6,0)
En aquest cas no retorna res, perquè no hi ha cap jugador amb la puntuació (6,0) */
SELECT (jugador).nom AS jugador FROM joc 
WHERE ((jugador).puntuacio).punts = 6 AND ((jugador).puntuacio).penalitzacions = 0;

-- 14: Anota un punt de penalització a Diego (independentment dels punts que porti en aquest moment).
UPDATE joc SET jugador = ROW((jugador).nom, (jugador).categoria, ROW(((jugador).puntuacio).punts, ((jugador).puntuacio).penalitzacions + 1)) 
WHERE (jugador).nom = 'Diego';

-- 15: Elimina tot el que has creat en aquest exercici. Tot.
DROP TABLE IF EXISTS joc;
DROP FUNCTION IF EXISTS obtenirPuntuacioRealJugador(punts);
DROP TYPE IF EXISTS jugador;
DROP TYPE IF EXISTS categoria;
DROP TYPE IF EXISTS categoria_nom;
DROP TYPE IF EXISTS punts;
DROP DOMAIN IF EXISTS nombres_positius;

