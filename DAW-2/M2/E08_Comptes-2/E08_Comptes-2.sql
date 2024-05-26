-- E08. Herència de taules. Comptes II.

/* Realitza les Consultes següents:
   1: Comptes dels clients que siguin accionistes. */
SELECT * FROM compte WHERE propietari IN (SELECT dni FROM accionistes);

-- 2: Comptes dels clients no accionistes.
SELECT * FROM compte WHERE propietari NOT IN (SELECT dni FROM accionistes);

-- 3: Comptes d'estalvi dels accionistes.
SELECT ce.* FROM compte_estalvi ce
INNER JOIN compte c ON ce.numero = c.numero
INNER JOIN accionistes a ON c.propietari = a.dni;

/* 4: Funció que rebi un compte com paràmetre i retorni una cadena de text amb la representació del 
      compte en el format: "12345 - Miguel Pérez [1234.80 euros]". */
CREATE FUNCTION representacio_compte(_compte_num INTEGER) RETURNS TEXT AS 
$$
	DECLARE propietari_nom VARCHAR(50);
	DECLARE saldo FLOAT;
	DECLARE representacio TEXT;
	BEGIN
	    SELECT cl.nom, c.saldo 
	    INTO propietari_nom, saldo
	    FROM compte c
	    INNER JOIN clients cl ON c.propietari = cl.dni
	    WHERE c.numero = _compte_num;
	
	    IF NOT FOUND THEN
	        RETURN 'El compte especificat no existeix.';
	    END IF;
	
	    representacio := _compte_num || ' - ' || propietari_nom ||
	                     ' [' || saldo || ' euros]';
	
	    RETURN representacio;
	END;
$$ LANGUAGE plpgsql;

SELECT representacio_compte(2101);

/* 5: Funció que rebi un DNI com paràmetre i retorni un booleà indicant si el DNI és vàlid (incloent la 
      comprovació de la lletra). */
CREATE FUNCTION validar_dni(_dni CHAR(9)) RETURNS boolean AS 
$$
	DECLARE nums INTEGER;
	DECLARE lletra CHAR(1);
	DECLARE lletraOK CHAR(1);
	BEGIN
		IF _dni !~ '[0-9]{8}[A-Z]' THEN
			RETURN false;
		END IF;

		nums := SUBSTRING(_dni FROM 1 FOR 8);
		lletra := SUBSTRING(_dni FROM 9 FOR 1);
		lletraOK := SUBSTRING('TRWAGMYFPDXBNJZSQVHLCKE', nums % 23 + 1, 1);

		IF  lletra = lletraOK THEN
			RETURN true;
		ELSE
			RETURN false;
		END IF;
	END;
$$ LANGUAGE plpgsql;

SELECT validar_dni('72874869J');

-- 6: Tornar a definir el domini per que el DNI es validi mitjançant aquesta funció.
ALTER TABLE clients
    ADD CONSTRAINT validar_dni_constraint
    CHECK (validar_dni(dni));

INSERT INTO clients (dni, nom, adreca, telefon, correu_electronic) VALUES 
	('61844102T', 'Arnau Vegas', ROW('Carrer les Parres', 47, 'Barcelona'), '123456789', 'arnau@gmail.com');

	-- Aquest no deixa insertar-ho, perque no en te un DNI vàlid.
	-- ('12345678W', 'Roberto Lopez', ROW('Carrer Sant Jaume', 47, 'Barcelona'), '123456789', 'roberto@gmail.com');

	
