/* La descripció RGB (de l'anglès Red, Green, Blue, vermell, verd i blau) d'un color fa referència 
   a la composició del color en termes de les intensitats dels colors primaris amb què es forma: del 
   vermell (red), del verd (green) i del blau (blue). És un model de color basat en la síntesi additiva, 
   amb el que és possible representar un color mitjançant la barreja per addició dels tres colors llum 
   primaris. [ wikipedia ]

   1: Defineix un tipus compost per treballar amb colors RGB. Permetrem treballar només amb 8 bits per cada 
   color primari, per tant tindrem 256 intensitats possibles, i ens donarà una paleta de colors de 16'7 
   milions de colors. */
CREATE TYPE color AS (
	red INTEGER,
	green INTEGER,
	blue INTEGER
);

/* 2: Hi ha certs colors que, per les serves característiques, reben un nom propi: VERMELL, VERD, BLAU, 
   GROC, TURQUESA, LILA. Crea una taula de dos columnes amb el nom i el color RGB al que correspon. Inserta 
   aquestes files. */
CREATE TABLE colors (
	nom VARCHAR(50),
	color color
);

INSERT INTO colors (nom, color) VALUES 
	('VERMELL', (255, 0, 0)),
	('VERD', (0, 255, 0)),
	('BLAU', (0, 0, 255)),
	('GROC', (255, 255, 0)),
	('TURQUESA', (64, 224, 208)),
	('LILA', (128, 0, 128));

/* 3: Defineix una funció per calcular la brillantor d'un color. (brillo = 0,2123*vermell + 0,7155*verd + 0,0713*blau). 
   Fes alguna consulta per provar la funció. */
CREATE FUNCTION calc_brillantor(_color color) RETURNS INT AS 
$$
	DECLARE brillantor INTEGER;
	BEGIN
		brillantor := round((0.2123 * (_color).red) + (0.7155 * (_color).green) + (0.0713 * (_color).blue));

		RETURN brillantor;
	END;
$$ LANGUAGE plpgsql;

SELECT calc_brillantor((255, 0, 0)) AS brillantor;

/* 4: Podem convertir un color RGB en un color d'Escala de Grisos a partir de la brillantor. Aquest color tindrà les 
   tres components iguals a la brillantor. Defineix una funció que rebi com paràmetre un color RGB i retorni un nou 
   color equivalent al donat en escala de grisos. Fes consultes per provar la funció. */
CREATE FUNCTION escala_grisos(_color color) RETURNS color AS 
$$
	DECLARE brillantor INTEGER;
	BEGIN
		brillantor := calc_brillantor(_color);

		RETURN (brillantor, brillantor, brillantor);
	END;
$$ LANGUAGE plpgsql;

SELECT escala_grisos((255, 255, 0)) AS grisos;

-- 5: Defineix una funció que ens retorni una cadena amb el codi hexadecimal del color. Fes consultes per provar la funció.
CREATE FUNCTION convertir_hex(_color color) RETURNS char(7) AS 
$$	
	DECLARE color_hex char(7);
	DECLARE red text;
	DECLARE green text;
	DECLARE blue text;
	BEGIN
		red := lpad(to_hex((_color).red), 2, '0');
		green := lpad(to_hex((_color).green), 2, '0');
		blue := lpad(to_hex((_color).blue), 2, '0');
		color_hex := '#' || red || green || blue;

		RETURN color_hex;
	END
$$ LANGUAGE plpgsql;

SELECT color, convertir_hex(color) FROM colors;

/* 6: Defineix una funció que rebi com paràmetre una cadena en format hexadecimal ( p.e. A3CE08 ) i retorni un objecte de tipus RGB. 
      Ajuda: pots provar-ho amb SELECT 'xA3'::bit(8)::int::byte; Inserta un nou color a partir de la seva cadena hexadecimal. */
CREATE FUNCTION convertir_rgb(_color_hex char(7)) RETURNS color AS
$$
	DECLARE red INTEGER;
	DECLARE green INTEGER;
	DECLARE blue INTEGER;
	BEGIN
		red := ('x' || substring(_color_hex from 2 for 2))::bit(8)::int;
		green := ('x' || substring(_color_hex from 4 for 2))::bit(8)::int;
		blue := ('x' || substring(_color_hex from 6 for 2))::bit(8)::int;

		RETURN (red, green, blue);
	END;
$$ LANGUAGE plpgsql;

INSERT INTO colors (nom, color) VALUES ('TARONJA', convertir_rgb('#FF8000')); 
SELECT * FROM colors WHERE nom = 'TARONJA';

-- 7: Definir un operador ~ per determinar si dos colors són similars en brillantor (diferència de luminància inferior a 30). 
CREATE FUNCTION colors_similars(_color_1 color, _color_2 color) RETURNS boolean AS
$$
	BEGIN
		RETURN abs(calc_brillantor(_color_1) - calc_brillantor(_color_2)) < 30;
	END;
$$ LANGUAGE plpgsql;

CREATE OPERATOR ~ (
	LEFTARG = color,
	RIGHTARG = color,
	PROCEDURE = colors_similars,
	COMMUTATOR = '~'
);

SELECT colors_similars((255, 0, 0), (255, 255, 0)) AS son_similars;

-- 8: Seleccionar tots els parells de colors similars en brillantor entre ells. (Fes servir l'operador definit abans).
SELECT c1.nom AS color_1, c2.nom AS color_2 FROM colors c1 
	INNER JOIN colors c2 ON c1.nom <> c2.nom AND c1.color ~ c2.color;

-- 9: Definir l'operador + per combinar dos colors i obtenir un nou color. La combinació es realitzarà calculant els valors mitjos de cada component).
CREATE FUNCTION colors_combinar(_color_1 color, _color_2 color) RETURNS color AS
$$
	DECLARE red_mitja INTEGER;
	DECLARE green_mitja INTEGER;
	DECLARE blue_mitja INTEGER;
	BEGIN
		red_mitja := ((_color_1).red + (_color_2).red) / 2;
		green_mitja := ((_color_1).green + (_color_2).green) / 2;
		blue_mitja := ((_color_1).blue + (_color_2).blue) / 2;

		RETURN (red_mitja, green_mitja, blue_mitja);
	END;
$$ LANGUAGE plpgsql;

CREATE OPERATOR + (
	LEFTARG = color,
	RIGHTARG = color,
	PROCEDURE = colors_combinar,
	COMMUTATOR = '+'
);

SELECT colors_combinar((255, 0, 0), (0, 0, 255)) AS color_combinat;
