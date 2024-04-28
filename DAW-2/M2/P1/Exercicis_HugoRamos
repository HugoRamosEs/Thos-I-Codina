-- 3: Crea un nou tipus de dades 'producto' amb dos atributs: 'nombre' (string de 50 caràcters) i 'precio' (monetari).
CREATE TYPE producto AS (
    nombre VARCHAR(50),
    precio MONEY
);

-- 4: Crea una taula anomenada 'inventario' amb dues columnes: 'item' (del tipus producto) i 'cantidad' (sencer).
CREATE TABLE inventario (
    item producto,
    cantidad INTEGER
);

-- 5: Insereix 8 registres en la base de dades. Fes servir els quatre mètodes explicats (2 registres amb cada mètode).
-- 1r MÈTODE:
INSERT INTO inventario VALUES
	(ROW('Pelota', 15.00::MONEY), 2),
	(ROW('Guantes', 30.00::MONEY), 4);

-- 2n MÈTODE:
INSERT INTO inventario VALUES 
  ((('Calcetines', 2.50::MONEY)::producto), 10),
  ((('Gafas', 75.00::MONEY)::producto), 1);

-- 3r MÈTODE:
INSERT INTO inventario VALUES 
  ('("Boligrafo", 1.00)', 40),
  ('("Tijeras", 3.00)', 3);

-- 4t MÈTODE:
INSERT INTO inventario (item, cantidad) VALUES 
  (ROW('Cascos', 125.00::MONEY), 20),
  (ROW('Botas', 50.00::MONEY), 15);

-- 6: Consulta les dades de l'inventari.
SELECT * FROM inventario;

-- 7: Obté l'article amb el preu màxim.
SELECT (item).nombre, (item).precio
FROM inventario
ORDER BY (item).precio DESC
LIMIT 1;

-- 8: Obté l'article que tingui la quantitat mínima.
SELECT (item).nombre, (item).precio
FROM inventario
ORDER BY (item).precio ASC
LIMIT 1;

-- 9: Obté els productes que tenen un preu superior a 60€ (hauràs de fer un cast).
SELECT (item).nombre, (item).precio
FROM inventario
WHERE CAST((item).precio AS NUMERIC) > 60.00;

-- 10: Elimina el tipus de dades 'producto'. Com afecta a la taula 'inventario'?
-- DROP TYPE producto;
/* No el deixa borrar perque a la taula inventari, un dels camps depen de l'objecte producto */
