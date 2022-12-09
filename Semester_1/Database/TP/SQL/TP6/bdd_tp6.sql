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
(1, 'BERNARD', '1 rue sous bois', 'Belfort', '90000', '0384545401', '2004-01-01', 'F', 'N', 1, 1, '11.50', '10.50'),
(19, 'CHAVEAUX', '5 rue du chasseur', 'Strasbourg', '68000', '0384545419', '2004-01-01', 'H', 'N', 2, 2, '10.50', '9.50'),
(20, 'PRETTOT', '8 rue vilapogo', 'Belfort', '90000', '0384545420', '2004-07-12', 'H', 'O', 2, 2, '12.50', '8.50'),
(7, 'RIOT', '67 rue pasteur', 'Montbeliard', '25200', '0384545407', '2004-06-06', 'H', 'N', 2, 1, '13.50', '12.50'),
(8, 'BOISSENIN', '1 rue sous bois', 'Belfort', '90000', '0384545408', '2004-08-09', 'H', 'O', 2, 1, '15.5', '16.50'),
(2, 'PEQUIGNOT', '2 rue de la liberation', 'Valdoie', '90300', '0384545402', '2003-06-06', 'H', 'O', 1, 1, '17.50', '9.50'),
(3, 'ZILLIOX', '7 rue du verger', 'Bavilliers', '90120', '0384545403', '2003-01-01', 'H', 'N', 1, 1, '11.50','9.25'),
(4, 'MONNIER', '3 rue du boulanger', 'TAILLECOURT', '25400', '0384545404', '2003-02-06', 'H', 'O', 1, 1, '9.50', '15.5'),
(5, 'BRISCHOUX', '5 rue du chasseur', 'Belfort', '90000', '0384545405', '2003-05-25', 'H', 'N', 2, 1, '10', '9.50'),
(6, 'DUVAL', '8 rue vilapogo', 'Bavilliers', '90120', '0384545406', '2003-03-11', 'H', 'O', 2, 1, '13.50', '8.50'),
   (10, 'FAIVRE', '7 rue des vergers  de rioz', 'Valdoie', '90300', '0384545410', '2003-01-05', 'H', 'O', 3, 1, '8.50', '12.50'),
(17, 'DELANOE', '7 rue du verger', 'Valdoie', '90300', '0384545417', '2003-01-01', 'H', 'N', 1, 2, '12.50', '14.50'),
(18, 'BONVALOT', '3 rue du boulanger', 'Belfort', '90000', '0384545418', '2003-01-01', 'H', 'O', 1, 2, '10', '11.50'),
(21, 'COULON', '67 rue pasteur', 'Valdoie', '90300', '0384545421', '2003-01-01', 'H', 'N', 2, 2, '17', '6.5'),
(23, 'KENDE', '2 rue de la liberation', 'Bavilliers', '90120', '0384545423', '2003-05-31', 'H', 'N', 3, 2, '15', '7.5'),
(24, 'KLEIN', '7 rue du verger', 'Montbeliard', '25200', '0384545424', '2003-01-01', 'H', 'N', 3, 2, '13', '15'),
(25, 'VALZER', '3 rue du boulanger', 'Valdoie', '90300', '0384545425', '2003-01-06', 'H', 'O', 3, 2, '11', '10'),
(26, 'PY', '5 rue du chasseur', NULL, '90000', '0384545426', '2003-01-10', 'F', 'N', 3, 2, '12.20', '7.90'),
(27, 'VERNET', '8 rue vilapogo', NULL, '90120', '0384545427', '2003-02-02', 'H', 'O', 4, 3, '10.30', '11.85'),
(28, 'BAILLIT', '67 rue pasteur', NULL, '25200', '0384545428', '2003-01-01', 'H', 'N', 4, 3, '7.90', '15.90'),
(16, 'LUZET', '2 rue de la liberation', 'Belfort', '90000', '0384545416', '2002-01-01', 'H', 'O', 1, 2, '10.25', '9.25'),
  (22, 'VALOT', '1 rue sous bois', '', '90000', '0384545422', '2002-12-12', 'H', 'O', 2, 2, '10', '9.20'),
(29, 'DUPONT', '8 rue vilapogo', '', '90300', '0384545429', '2002-06-06', 'H', 'O', 4, 3, '13.20', '15.50'),
   (11, 'FAIVRE', '3 rue des vergers', 'Cernay', '68000', '0384545411', '2002-01-01', 'F', 'N', 3, 1, '5.6', '12.05'),
(12, 'DUCHENNE', '5 rue du chasseur', 'Belfort', '90000', '0384545412', '2002-01-01', 'F', 'O', 3, 1, '10.4', '11.3'),
(13, 'BOULANGER', '8 rue vilapogo', 'Belfort', '90000', '0384545413', '2002-01-01', 'F', 'N', 1, 2, '13', '9.20'),
   (9, 'FONTAINE-LEGIOT', '2 rue des vergers', 'Mulhouse', '68000', '0384545409', '2001-01-01', 'H', 'N', 3, 1, '11.25', '12'),
(14, 'MOREAU', '67 rue pasteur', 'Belfort', '90000', '0384545414', '2001-06-01', 'H', 'O', 1, 2, '9', '12.50'),
(15, 'RIGOULOT', '1 rue sous bois', 'Valdoie', '90300', '0384545415', '2001-12-12', 'H', 'N', 1, 2, '15', '10.50');

SELECT nom, note_ue1 , note_ue1*2 AS note_ue1_sur_40
FROM Etudiant
WHERE note_ue1 >= 14
ORDER BY note_ue1;

SELECT nom, note_ue1, note_ue2, ((note_ue1 + note_ue2) / 2) AS moyenne_ue
FROM Etudiant
WHERE note_ue1 >= 14
ORDER BY groupe_id DESC, moyenne_ue DESC;

SELECT nom, note_ue1, note_ue2, ((note_ue1 + note_ue2) / 2) AS moyenne_ue
FROM Etudiant
HAVING moyenne_ue >= 13
ORDER BY moyenne_ue, groupe_id;

SELECT concat('année :',year(now())) ;
SELECT concat('année :',year(now())) AS TEST;

SELECT nom, (concat(day(date_naissance), "/", month(date_naissance), "/", year(date_naissance))) as naissance
FROM Etudiant
WHERE year(date_naissance) >= 2004
ORDER BY date_naissance DESC;

SELECT COUNT(Etudiant.idEtudiant) AS Nbre_etudiants, Etudiant.groupe_id
FROM Etudiant
GROUP BY Etudiant.groupe_id;

SELECT COUNT(Etudiant.idEtudiant) AS Nbre_etudiants, Etudiant.groupe_id, semestre_id
FROM Etudiant
GROUP BY Etudiant.groupe_id, semestre_id;

SELECT groupe_id,
       semestre_id,
       GROUP_CONCAT(note_ue1) AS liste,
       COUNT(*),
       MIN(note_ue1),
       max(note_ue1),
       ROUND(AVG(note_ue1), 2) AS moy
FROM Etudiant
GROUP BY groupe_id, semestre_id;

SELECT COUNT(*) as Nbre_etudiants, code_postal, sexe
FROM Etudiant
WHERE code_postal LIKE "90%" AND sexe = "H"
GROUP BY code_postal;

SELECT COUNT(*) as Nbre_etudiants, sexe
FROM Etudiant
WHERE code_postal LIKE "90%"
GROUP BY sexe;

SELECT COUNT(*) as Nbre_etudiants
FROM Etudiant
WHERE code_postal LIKE "90%" AND sexe = "H";

SELECT COUNT(*) as Nbre_etudiants_fcomte
FROM Etudiant
WHERE
    code_postal LIKE "90%" OR
    code_postal LIKE "25%" OR
    code_postal LIKE "39%" OR
    code_postal LIKE "70%";

SELECT
    ROUND(AVG(note_ue1), 2) as moyenne_ue1,
    ROUND(AVG(note_ue2), 2) as moyenne_ue2,
    ROUND((AVG(note_ue1) + AVG(note_ue2)) / 2, 2) as moyenne,
    groupe_id,
    semestre_id
FROM Etudiant
GROUP BY groupe_id, semestre_id
ORDER BY semestre_id, groupe_id;

ALTER TABLE Etudiant
ADD resultat_semestre VARCHAR(3);
UPDATE Etudiant
SET resultat_semestre = "ADM"
WHERE note_ue1 > 8 AND note_ue2 > 8 AND (note_ue1 + note_ue2) / 2 > 10;
SELECT COUNT(*) as nbre_admis
FROM Etudiant
WHERE resultat_semestre = "ADM"
GROUP BY resultat_semestre;

SELECT date_naissance,
       DATE_ADD(date_naissance, INTERVAL 18 YEAR) AS plus18,
       DATEDIFF(curdate(), DATE_ADD(date_naissance,INTERVAL 18 YEAR)) AS diff_jours_majorite
FROM Etudiant;

SELECT COUNT(*) as nbre_majeurs
FROM Etudiant
WHERE DATEDIFF(curdate(), DATE_ADD(date_naissance,INTERVAL 18 YEAR)) >= 0;

SELECT IF(note_ue1>=10 ,"UE1 validé - Jury","Jury") AS DECISION, nom
FROM Etudiant;
SELECT IF(note_ue2>=10 ,"UE2 validé","Jury") AS DECISION, nom
FROM Etudiant;
SELECT IF(note_ue1>=8 AND note_ue2 >=8 AND (note_ue1+note_ue2)>20,"ADM","Jury") AS DECISION, nom
FROM Etudiant;

SELECT nom,
       note_ue1,
       note_ue2,
       (note_ue1 + note_ue2) / 2 AS moyenne,
       IF(
           note_ue1 > 8 AND note_ue2 > 8 AND (note_ue1 + note_ue2) / 2 > 10, "ADM",
           IF(note_ue1 >= 10 AND (note_ue1 + note_ue2) / 2 <= 10, "UE1 validé – Jury",
               IF(note_ue2 >= 10 AND (note_ue1 + note_ue2) / 2 <= 10, "UE2 validé – Jury", "Jury")
            )
        ) AS DECISION
FROM Etudiant;

DROP TABLE IF EXISTS Etudiant;
