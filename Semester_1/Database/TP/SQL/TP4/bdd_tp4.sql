DROP TABLE IF EXISTS produit

CREATE TABLE produit (
    id_produit INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nom VARCHAR(20),
    categorie VARCHAR(20),
    code VARCHAR(5),
    prix NUMERIC(7,2),
    date_achat DATE
);

INSERT INTO produit VALUES (null, "Pommes", "fruits", "01002", 4.5, "2021-10-1");
INSERT INTO produit VALUES (null, "Poires", "fruits", "01008", 4, "2021-09-30");
INSERT INTO produit VALUES (null, "Potiron", "légumes", "02018", 3, "2021-09-21");
INSERT INTO produit VALUES (null, "Haricots", "légumes", "02089", 18, "2021-10-2");
INSERT INTO produit VALUES (null, "Cerises", "fruits", "01068", 15, "2021-09-30");
INSERT INTO produit VALUES (null, "Patates", "légumes", "02068", 3, "2021-09-30");

-- SELECT nom FROM produit WHERE prix >10;
-- SELECT nom FROM produit WHERE prix >= 10 && prix <= 15;
-- SELECT nom, prix FROM produit WHERE prix BETWEEN 10 AND 15;
-- SELECT nom FROM produit WHERE categorie = "légumes";
DELETE FROM produit WHERE id_produit = 2;
INSERT INTO produit VALUES (null, "Poires", "fruits", "01008", 4, "2021-09-30");

UPDATE produit SET nom = "Pommes de Terre", prix = 3.5 WHERE id_produit = 6;
UPDATE produit SET prix = 1 WHERE id_produit = 5;

ALTER TABLE produit ADD quantite NUMERIC(7,2) AFTER code;
ALTER TABLE produit DROP COLUMN code;
ALTER TABLE produit CHANGE prix prix NUMERIC(19,4);

INSERT INTO produit VALUES (null, "tomate", "Légume", 5, 4, "2021-09-30");
INSERT INTO produit VALUES (null, "salade verte", "legumes", 5, 1.5, "2021-09-30");
INSERT INTO produit VALUES (null, "radis noir", "LEGUMES", 5, 3.5, "2021-09-30");

-- SELECT nom, categorie FROM produit WHERE categorie != "fruits";

ALTER TABLE produit ADD categorie_id INT AFTER categorie;

SELECT * FROM produit;

DROP TABLE IF EXISTS produit;
