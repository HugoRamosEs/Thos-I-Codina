-- E02_Primeres-Passes-Inventari

-- 1: Necessito una taula amb tots els articles , el seu preu i el preu amb IVA.
SELECT (item).nombre AS article, (item).precio AS preu, (item).precio * 1.16 AS preu_amb_iva FROM inventario;

/* 2: Com estem en temps de crisi, el jefe ens demana si hi ha alguna forma de fer una baixada generalitzada 
      de preus d'un 7% sense haver de modificar cadascun dels article en el programa de facturació. */
UPDATE inventario SET item = ROW((item).nombre, (item).precio * 0.93);

-- 3: Necessito saber el nom dels articles estan per sota de la quantitat de trencament d'stock (2 articles).
SELECT (item).nombre AS article FROM inventario WHERE cantidad <= 2;

-- 4: Has d'obtenir una taula que tingui el nom i la quantitat d'articles que tenim disponibles.
SELECT (item).nombre AS article, cantidad AS quantitat FROM inventario;

-- 5: Hem d'obtenir el nom dels articles que tenen un stock (quantitat) per sobre de la mitja.
SELECT (item).nombre AS article FROM inventario WHERE cantidad > (SELECT AVG(cantidad) FROM inventario);
