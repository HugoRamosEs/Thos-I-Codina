/* Volem emmagatzemar en una taula els noms d'un grup de persones junt al numero d'identificació, 
   però algunes d'elles aporten DNI, NIE o passaport. */

/* 1: Defineix un tipus de dada compost per identificar a una persona, que inclogui el tipus de document 
	  i el número d'identificació. Fes servir un tipus enumerat per seleccionar el tipus de document. */
CREATE TYPE identificador AS ENUM ('DNI', 'NIE', 'Passaport');
CREATE TYPE persona AS (
	doc identificador,
	num CHAR(9)
);

-- 2: Crea una taula per emmagatzemar la informació d'aquestes persones.
CREATE TABLE practica_4 (
	id SERIAL PRIMARY KEY,
	persona persona
);

-- 3: Inserta varies files de prova.
INSERT INTO practica_4 (persona) VALUES
	(('DNI', '12345678Q')),
	(('DNI', '87654321E')),
	(('DNI', '12121212T')),
	(('DNI', '13131313U')),
	(('NIE', 'Y1234567Z')),
	(('NIE', 'A1234567B')),
	(('NIE', 'P1234567C')),
	(('NIE', 'L8765432Q')),
	(('Passaport', 'ZAB000254')),
	(('Passaport', 'ABC111684')),
	(('Passaport', 'HJK121245')),
	(('Passaport', 'LQT752349'));

-- 4: Busca una persona a partir del número d'identificació.
SELECT * FROM practica_4 WHERE (persona).num = 'L8765432Q';

-- 5: Llista totes les persones que tenen passaport.
SELECT * FROM practica_4 WHERE (persona).doc = 'Passaport';

-- 6: Llista tots els números de DNI de la taula.
SELECT (persona).num FROM practica_4 WHERE (persona).doc = 'DNI';

-- 7: Una persona es va identificar amb el passaport, però ara aporta el DNI. Guarda'l.
UPDATE practica_4 SET persona = ('DNI', '12345678C')::persona
WHERE (persona).num = 'LQT752349';

-- 8: Modifica el número de passaport d'una persona.
UPDATE practica_4 SET persona = ('Passaport', 'CBA987654')::persona
WHERE (persona).doc = 'Passaport' AND (persona).num = 'ABC111684';
