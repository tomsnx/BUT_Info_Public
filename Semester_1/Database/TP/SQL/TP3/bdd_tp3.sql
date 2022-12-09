CREATE TABLE etudiant (
    id_etu INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nom VARCHAR(20),
    adresse TEXT,
    code_postal VARCHAR(5),
    telephone VARCHAR(10),
    date_naissance DATE,
    PRIMARY KEY (id_etu)
);

INSERT INTO etudiant VALUES (NULL, 'dupond', 'rue du chateau', '25000', '0123456789', '1990-12-31');
INSERT INTO etudiant VALUES (NULL, 'durant', 'rue du pont', '25490', '0123456789', '1990-12-31');
INSERT INTO etudiant VALUES (NULL, 'DAVAL', 'rue du CHATEAU', '90000', '0123456789', '1990-12-31');

DESCRIBE etudiant;
SELECT * FROM etudiant;

RENAME TABLE etudiant TO etudiants;
SHOW TABLES;

ALTER TABLE etudiants ADD groupe VARCHAR(20);
DESCRIBE etudiants;
SELECT * FROM etudiants;

ALTER TABLE etudiants ADD prenom VARCHAR(20) AFTER nom;
DESCRIBE etudiants;
SELECT * FROM etudiants;

ALTER TABLE etudiants DROP COLUMN groupe;
DESCRIBE etudiants;
SELECT * FROM etudiants;

ALTER TABLE etudiants CHANGE prenom prenoms VARCHAR(50);
DESCRIBE etudiants;
SELECT * FROM etudiants;

ALTER TABLE etudiants CHANGE telephone telephone CHAR(13);
DESCRIBE etudiants;
SELECT * FROM etudiants;

DROP TABLE IF EXISTS etudiant;
DROP TABLE etudiants;
