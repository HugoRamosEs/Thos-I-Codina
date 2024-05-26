-- E07. Herència de taules. Comptes I.

-- 3: Per a l'adreça s'utilitzarà un tipus compost amb el carrer, número i població.
CREATE TYPE adreca AS (
	carrer VARCHAR(100),
	numero INTEGER,
	poblacio VARCHAR(50)
);

-- 4: Pel telèfon i el correu electrònic s'ha de definir el tipus que verifiqui el format dels valors.
CREATE DOMAIN telefon AS CHAR(9) CHECK (VALUE ~ '^[0-9]{9}$');
CREATE DOMAIN correu AS VARCHAR(100) CHECK (VALUE ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$');
-- Verificacions de dades extra:
CREATE DOMAIN nombre_accions AS INTEGER CHECK (VALUE >= 0);

-- 1: De cada client guardem seu DNI, nom, adreça, telèfon i correu electrònic.
CREATE TABLE clients (
	dni CHAR(9) PRIMARY KEY,
	nom VARCHAR(50),
	adreca adreca,
	telefon telefon,
	correu_electronic correu
);

-- 2: A més alguns clients són Accionistes i d'ells guardem el nombre d'accions que tenen.
CREATE TABLE accionistes (
    nombre_accions nombre_accions,
    FOREIGN KEY (dni) REFERENCES clients(dni)
) INHERITS (clients);

-- 5: Els comptes tenen número de compte, propietari i saldo.
CREATE TABLE compte (
    numero INTEGER PRIMARY KEY,
    propietari CHAR(9) REFERENCES clients(dni),
    saldo FLOAT
);

-- 6: Un compte por ser de dos tipus: compte d'estalvi o compte corrent.
-- 7: Els comptes d'estalvi tenen un tipus d'interès i els comptes corrents un límit de números vermells).
CREATE TABLE compte_estalvi (
    tipus_interes FLOAT,
    FOREIGN KEY (numero) REFERENCES compte(numero)
) INHERITS (compte);

CREATE TABLE compte_corrent (
    limit_numeros_vermells FLOAT,
    FOREIGN KEY (numero) REFERENCES compte(numero)
) INHERITS (compte);

-- 10: Inserta dades.
INSERT INTO clients (dni, nom, adreca, telefon, correu_electronic) VALUES 
	('12345678Z', 'Mario Ramos', ROW('Carrer Cantabria', 47, 'Barcelona'), '123456789', 'mario@gmail.com'),
    ('87654321X', 'Alex Rodriguez', ROW('Gran Via', 21, 'Valencia'), '987654321', 'alex@gmail.com'),
	('80807410S', 'Hugo Ramos', ROW('Riera de Cirera', 57, 'Mataró'), '123456789', 'hugo@gmail.com'),
    ('72874869J', 'Hector Monroy', ROW('Paisos catalans', 9, 'Premia de mar'), '987654321', 'hector@gmail.com');

INSERT INTO accionistes (dni, nombre_accions) VALUES
	('12345678Z', 37),
    ('87654321X', 108);

INSERT INTO compte (numero, propietari, saldo) VALUES
	(2101, '12345678Z', 2320.50),
	(1529, '87654321X', 1567.75),
	(3333, '80807410S', 2145.25),
	(1111, '72874869J', 1762.0);

INSERT INTO compte_estalvi (numero, tipus_interes) VALUES
	(2101, 0.05),
	(1529, 1.50);

INSERT INTO compte_corrent (numero, limit_numeros_vermells) VALUES
	(3333, -500.0),
	(1111, -250.0);
