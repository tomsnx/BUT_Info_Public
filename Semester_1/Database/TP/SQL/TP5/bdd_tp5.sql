DROP TABLE IF EXISTS Etudiant;

CREATE TABLE Etudiant (
    idEtudiant INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nom VARCHAR(20),
    adresse VARCHAR(40),
    ville VARCHAR(20),
    code_postal INT,
    telephone VARCHAR(13),
    date_naissance DATE,
    sexe VARCHAR(1),
    boursier VARCHAR(1),
    groupe_id INT,
    semestre_id INT,
    note_ue1 NUMERIC(4, 2),
    note_ue2 NUMERIC(4, 2)
);

INSERT INTO Etudiant (idEtudiant, nom, adresse, ville, code_postal, telephone, date_naissance, sexe, boursier, groupe_id, semestre_id, note_ue1, note_ue2) VALUES
(1, 'BERNARD', '1 rue sous bois', 'Belfort', 90000, '0384545401', '2003-01-01', 'F', 'N', 1, 1, 10.50, 9.50),
(19, 'CHAVEAUX', '5 rue du chasseur', 'Strasbourg', 68000, '0384545419', '2003-01-01', 'H', 'N', 2, 2, 10.50, 9.50),
(20, 'PRETTOT', '8 rue vilapogo', 'Belfort', 90000, '0384545420', '2003-07-12', 'H', 'O', 2, 2, 13.50, 8.50),
(7, 'RIOT', '67 rue pasteur', 'Montbeliard', 25200, '0384545407', '2003-06-06', 'H', 'N', 2, 1, 13.50, 12.50),
(8, 'BOISSENIN', '1 rue sous bois', 'Belfort', 90000, '0384545408', '2003-08-09', 'H', 'O', 2, 1, 13.50, 15.50),
(2, 'PEQUIGNOT', '2 rue de la liberation', 'Valdoie', 90300, '0384545402', '2002-06-06', 'H', 'O', 1, 1, 7.50, 13.50),
(3, 'ZILLIOX', '7 rue du verger', 'Bavilliers', 90120, '0384545403', '2002-01-01', 'H', 'N', 1, 1, 13.50, 7.50),
(4, 'MONNIER', '3 rue du boulanger', 'TAILLECOURT', 25400, '0384545404', '2002-02-06', 'H', 'O', 1, 1, 13.50, 8.50),
(5, 'BRISCHOUX', '5 rue du chasseur', 'Belfort', 90000, '0384545405', '2002-05-25', 'H', 'N', 2, 1, 10.50, 9.50),
(6, 'DUVAL', '8 rue vilapogo', 'Bavilliers', 90120, '0384545406', '2002-03-11', 'H', 'O', 2, 1, 13.50, 8.50),
   (10, 'FAIVRE', '7 rue des vergers  de rioz', 'Valdoie', 90300, '0384545410', '2002-01-05', 'H', 'O', 3, 1, 8.50, 12.50),
(17, 'DELANOE', '7 rue du verger', 'Valdoie', 90300, '0384545417', '2002-01-01', 'H', 'N', 1, 2, 12.50, 12.50),
(18, 'BONVALOT', '3 rue du boulanger', 'Belfort', 90000, '0384545418', '2002-01-01', 'H', 'O', 1, 2, 10.50, 11.50),
(21, 'COULON', '67 rue pasteur', 'Valdoie', 90300, '0384545421', '2002-01-01', 'H', 'N', 2, 2, 10.50, 11.50),
(23, 'KENDE', '2 rue de la liberation', 'Bavilliers', 90120, '0384545423', '2002-05-31', 'H', 'N', 3, 2, 10.50, 11.50),
(24, 'KLEIN', '7 rue du verger', 'Montbeliard', 25200, '0384545424', '2002-01-01', 'H', 'N', 3, 2, 13.50, 8.50),
(25, 'VALZER', '3 rue du boulanger', 'Valdoie', 90300, '0384545425', '2002-01-06', 'H', 'O', 3, 2, 13.50, 8.50),
(26, 'PY', '5 rue du chasseur', NULL, 90000, '0384545426', '2002-01-10', 'F', 'N', 3, 2, 13.50, 7.50),
(27, 'VERNET', '8 rue vilapogo', NULL, 90120, '0384545427', '2002-02-02', 'H', 'O', 4, 3, 10.50, 11.50),
(28, 'BAILLIT', '67 rue pasteur', NULL, 25200, '0384545428', '2002-01-01', 'H', 'N', 4, 3, 7.50, 15.50),
(16, 'LUZET', '2 rue de la liberation', 'Belfort', 90000, '0384545416', '2001-01-01', 'H', 'O', 1, 2, 10.50, 9.20),
  (22, 'VALOT', '1 rue sous bois', '', 90000, '0384545422', '2001-12-12', 'H', 'O', 2, 2, 10.50, 9.20),
(29, 'DUPONT', '8 rue vilapogo', '', 90300, '0384545429', '2001-06-06', 'H', 'O', 4, 3, 13.50, 15.50),
   (11, 'FAIVRE', '3 rue des vergers', 'Cernay', 68000, '0384545411', '2001-01-01', 'F', 'N', 3, 1, 7.50, 12.50),
(12, 'DUCHENNE', '5 rue du chasseur', 'Belfort', 90000, '0384545412', '2001-01-01', 'F', 'O', 3, 1, 10.50, 11.50),
(13, 'BOULANGER', '8 rue vilapogo', 'Belfort', 90000, '0384545413', '2001-01-01', 'F', 'N', 1, 2, 10.50, 9.20),
   (9, 'FONTAINE-LEGIOT', '2 rue des vergers', 'Mulhouse', 68000, '0384545409', '2001-01-01', 'H', 'N', 3, 1, 13.50, 12.50),
(14, 'MOREAU', '67 rue pasteur', 'Belfort', 90000, '0384545414', '2000-06-01', 'H', 'O', 1, 2, 9.50, 12.50),
(15, 'RIGOULOT', '1 rue sous bois', 'Valdoie', 90300, '0384545415', '2000-12-12', 'H', 'N', 1, 2, 13.50, 10.50);

SELECT Etudiant.nom,
       Etudiant.adresse,
       Etudiant.semestre_id
FROM Etudiant
WHERE Etudiant.groupe_id = 1 AND Etudiant.ville = "Belfort";

SELECT nom, groupe_id, boursier
FROM Etudiant
WHERE groupe_id = 1 AND semestre_id = 1 AND boursier = "O";

SELECT semestre_id, groupe_id, nom
FROM Etudiant
ORDER BY semestre_id ASC, groupe_id, nom DESC;

SELECT nom, ville FROM Etudiant WHERE groupe_id = 2 ORDER BY ville DESC, nom ASC;

SELECT nom, groupe_id, ville, semestre_id
FROM Etudiant
WHERE (groupe_id = 1 AND semestre_id = 1) OR (semestre_id = 2 AND ville = "Belfort")
ORDER BY semestre_id ASC, groupe_id ASC, ville ASC, nom DESC;

SELECT nom, groupe_id, semestre_id, ville, code_postal
FROM Etudiant
WHERE (semestre_id <> 2 AND code_postal BETWEEN 90000 AND 90999) AND ville != "Belfort" AND ville != "" AND ville IS NOT NULL
ORDER BY semestre_id, groupe_id, ville, nom;

SELECT nom, groupe_id, ville, semestre_id, boursier
FROM Etudiant
WHERE (boursier = "O" OR ville = "Belfort") AND semestre_id = 2
ORDER BY groupe_id, ville, nom;

SELECT DISTINCT ville
FROM Etudiant
WHERE ville != "" && ville IS NOT NULL && code_postal BETWEEN 90000 AND 90999;

SELECT nom, ville
FROM Etudiant
WHERE ville IN ('Mulhouse', 'Cernay', 'Strasbourg');

SELECT nom, ville
FROM Etudiant
WHERE (ville IS NULL || ville = "") && sexe = 'H';

SELECT nom, ville
FROM Etudiant
WHERE (nom LIKE 'B%' OR nom LIKE 'D%')
AND ville LIKE '%o%'
ORDER BY nom;

SELECT nom, ville, adresse
FROM Etudiant
WHERE adresse LIKE '%verger%' AND (ville LIKE '%er%' OR ville LIKE '%al%')
ORDER BY nom, adresse;

SELECT nom, groupe_id
FROM Etudiant
ORDER BY groupe_id DESC, nom
LIMIT 6;
SELECT nom, groupe_id
FROM Etudiant
ORDER BY groupe_id DESC, nom
LIMIT 6, 4;

SELECT nom, date_naissance
FROM Etudiant
WHERE
-- date_naissance BETWEEN "2001-1-1" AND "2001-12-31"
date_naissance LIKE "2001%"
AND sexe = 'H'
AND (code_postal = 90000 OR ville = 25200)
ORDER BY date_naissance;

-- '[0-9]5[0-9][0-9][0-9]'
-- '_(a|e)_%'

SELECT nom, code_postal
FROM Etudiant
WHERE nom LIKE '_(a|e)_%' AND code_postal REGEXP '[0-9]5[0-9][0-9][0-9]';

DROP TABLE IF EXISTS Etudiant;
