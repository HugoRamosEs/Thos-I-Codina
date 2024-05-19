/* Matemàticament un punt és un conjunt de 3 nombres ordenats, anomenats coordenades del punt, i representen la 
   distància a cadascun dels eixos de coordenades. Es representa per (x,y,z). Un vector és un concepte matemàtic 
   que representa un segment (línia recta entre dos punts) orientat (amb direcció un sentit). Es representa com 
   la diferència entre el punt origen i el punt final:
   - (x,y,z) = P1(x1, y1,z1) – P2(x2, y2, z2) = (x2-x1, y2-y1, z2-z1)
   - (0,0,0) (1,1,1) (8,8,8) (1,2,4) (6,12,24) (-2,6,1)

1. Defineix els tipus de dades compostos per treballar amb punts i vectors. */
CREATE TYPE punt AS (
    x FLOAT,
    y FLOAT,
    z FLOAT
);

CREATE TYPE vector AS (
    x FLOAT,
    y FLOAT,
    z FLOAT
);

-- 2. Defineix la funció que genera un vector en funció de dos punts donats.
CREATE FUNCTION generar_vector(_p1 punt, _p2 punt) RETURNS vector AS 
$$
	DECLARE resultat vector;
	BEGIN
    	resultat.x := _p2.x - _p1.x;
    	resultat.y := _p2.y - _p1.y;
    	resultat.z := _p2.z - _p1.z;
    	RETURN resultat;
	END;
$$ LANGUAGE plpgsql;

/* 3. Es defineix l'adició (o suma) de vectors com un vector resultant on les components del vector suma són la suma 
      de les components dels sumands. (x,y,z) = v1(x1, y1,z1) + v2(x2, y2, z2) = (x2+x1, y2+y1, z2+z1) Crea l'operador 
      + per aquesta operació vectorial. */
CREATE FUNCTION suma_vectors(_v1 vector, _v2 vector) RETURNS vector AS
$$
	DECLARE resultat vector;
	BEGIN
    	resultat.x := _v1.x + _v2.x;
    	resultat.y := _v1.y + _v2.y;
    	resultat.z := _v1.z + _v2.z;
    	RETURN resultat;
	END;
$$ LANGUAGE plpgsql;

CREATE OPERATOR + (
    LEFTARG = vector,
    RIGHTARG = vector,
    FUNCTION = suma_vectors
);

/* 4. El mòdul d'un vector representa la longitud del segment que va de l'origen a l'extrem, i es calcula aplicant el Teorema 
      de Pitàgores: |v| = SQRT( ( x1,)2 + ( y1,) 2 + ( z1) 2 ) Defineix la funció que calcula el mòdul. */
CREATE FUNCTION modul_vector(_v vector) RETURNS FLOAT AS
$$
	DECLARE resultat FLOAT;
	BEGIN
    	resultat := sqrt(_v.x^2 + _v.y^2 + _v.z^2);
    	RETURN resultat;
	END;
$$ LANGUAGE plpgsql;

/* 5. Vector unitari és aquell vector que té per mòdul 1. Per calcular el vector unitari equivalent de qualsevol vectors, haurem 
      de dividir cadascuna de les components pel mòdul: (x,y,z) = ( x/|v| , y/|v| , z/|v|) Dos vectors són equivalents, si el seu 
      vector unitari és el mateix. Defineix l'operador ~ per determinar si dos vectors són equivalent. */
CREATE FUNCTION vector_unitari(_v vector) RETURNS vector AS 
$$
	DECLARE modul FLOAT;
    DECLARE	resultat vector;
	BEGIN
    	modul := modul_vector(_v);
    	resultat.x := _v.x / modul;
    	resultat.y := _v.y / modul;
    	resultat.z := _v.z / modul;
    	RETURN resultat;
	END;
$$ LANGUAGE plpgsql;

CREATE FUNCTION vectors_equivalents(_v1 vector, _v2 vector) RETURNS BOOLEAN AS
$$
	BEGIN
    	RETURN vector_unitari(_v1) = vector_unitari(_v2);
	END;
$$ LANGUAGE plpgsql;

CREATE OPERATOR ~ (
    LEFTARG = vector,
    RIGHTARG = vector,
    FUNCTION = vectors_equivalents
);

-- 6. Amb els punts següents, calcula tots els parells de vectors equivalents i no repetits possibles.
CREATE TABLE punts (
    id SERIAL PRIMARY KEY,
    p punt
);

INSERT INTO punts (p) VALUES 
    ((1,1,1)),
    ((2,2,2)),
    ((3,3,3)),
    ((2,9,4)),
    ((6,12,24)),
    ((-2,13,1));

CREATE TEMP TABLE vectors AS
    SELECT p1.id AS id1, p2.id AS id2, generar_vector(p1.p, p2.p) AS v
    FROM punts p1, punts p2
    WHERE p1.id < p2.id;

SELECT v1.id1 AS id1_1, v1.id2 AS id2_1, v2.id1 AS id1_2, v2.id2 AS id2_2
	FROM vectors v1, vectors v2
	WHERE v1.v ~ v2.v AND v1.id1 < v2.id1;
