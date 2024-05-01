-- E02_Primeres-Passes-Inventari
-- 1: Necessito una taula amb tots els articles , el seu preu i el preu amb IVA.
-- SELECT (item).nombre AS article, (item).precio AS preu, (item).precio * 1.16 AS preu_amb_iva FROM inventario;

/* 2: Com estem en temps de crisi, el jefe ens demana si hi ha alguna forma de fer una baixada generalitzada 
      de preus d'un 7% sense haver de modificar cadascun dels article en el programa de facturació. */
UPDATE inventario SET (item).precio = (item).precio * 0.93;
