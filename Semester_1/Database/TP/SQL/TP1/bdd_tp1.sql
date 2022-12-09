-- mysql --user=ehumber4 --password=1407 --host=serveurmysql --database=BDD_ehumber4

CREATE TABLE etudiant (
    id_etudiant INT,
    nom_etudiant VARCHAR(25),
    date_naissance VARCHAR(25),
    PRIMARY KEY (id_etudiant)
);

DESCRIBE etudiant;

INSERT INTO etudiant (id_etudiant, nom_etudiant, date_naissance) VALUES (1, 'dupond', "14/07/2004");
INSERT INTO etudiant VALUES (2, 'durand', "15/12/2021");
INSERT INTO etudiant VALUES (1, 'Gauthier');
INSERT INTO etudiant VALUES (NULL, 'laval');
INSERT INTO etudiant (nom_etudiant) VALUES ('lepaul');

SELECT * FROM etudiant;

SHOW CREATE TABLE etudiant;

DROP TABLE IF EXISTS etudiant;
