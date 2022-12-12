-- Supprimer une table si elle existe à l'éxécution du script
DROP TABLE IF EXISTS autre_table;
DROP TABLE IF EXISTS une_table;

-- Types de données
INT(nbTotal)
VARCHAR(nbChar)
DATE
NUMERIC(nbTotal, nbApresVirgule)
DECIMAL(nbTotal, nbApresVirgule)

-- Créer une table
CREATE TABLE une_table(
    id INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL
    date_naissance DATE,
    PRIMARY KEY (id)
);

-- Créer une autre table avec une clé étrangère
CREATE TABLE autre_table(
    id INT NOT NULL AUTO_INCREMENT,
    nom_table VARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES une_table(id)
)

-- Insérer des données dans une table
INSERT INTO une_table(id, nom, prenom, date_naissance)
VALUES (NULL, 'AAA', 'aaa', '1990-01-01'),
VALUES (NULL, 'BBB', 'bbb', '1990-02-01'),
VALUES (NULL, 'CCC', 'ccc', '1990-03-01');

-- Afficher une table avec les types de données et les paramètres
DESCRIBE une_table;

-- Séléctionner des données
SELECT * FROM une_table;

-- Séléctionner des données avec une condition
SELECT * FROM une_table
WHERE nom = 'AAA';

-- Séléctionner des données avec une condition et un opérateur logique (AND)
SELECT * FROM une_table
WHERE nom = 'AAA' AND prenom = 'aaa';

-- Séléctionner des données avec une condition et un opérateur logique (OR)
SELECT * FROM une_table
WHERE nom = 'AAA' OR prenom = 'aaa';

-- Séléctionner des données qui commence par une chaine de caractères donnée
SELECT * FROM une_table
WHERE nom LIKE 'A%';

-- Séléctionner des données qui contient une chaine de caractères donnée
SELECT * FROM une_table
WHERE nom LIKE '%A%';

-- Séléctionner des données qui fini par une chaine de caractères donnée
SELECT * FROM une_table
WHERE nom LIKE '%A';

-- Séléctionner des données avec une date comprise entre deux dates
SELECT * FROM une_table
WHERE date_naissance BETWEEN '1990-01-01' AND '1990-03-01';

-- Séléctionner une donnée en particulier
SELECT nom FROM une_table;

-- Sélectionner une donnée en particulier sans doublon
SELECT DISTINCT nom FROM une_table;

-- Séléctionner une donnée en particulier avec un alias
SELECT nom AS nom_ville FROM une_table;

-- Séléctionner une donnée en particulier avec un alias et une condition
SELECT nom AS nom_ville FROM une_table
WHERE nom = 'AAA';

-- Ordonner les données par ordre croissant
SELECT * FROM une_table
ORDER BY nom ASC;

-- Ordonner les données par ordre décroissant
SELECT * FROM une_table
ORDER BY nom DESC;

-- Grouper les données par une colonne
SELECT * FROM une_table
GROUP BY nom;

-- Comtper le nombre de valeurs dans une colonne
SELECT COUNT(id) AS nb_id FROM une_table;

-- Faire une moyenne sur une colonne
SELECT AVG(id) AS moyenne_id FROM une_table;

-- Faire une somme sur une colonne
SELECT SUM(id) AS somme_id FROM une_table;

-- Trouver une valeur max dans une colonne
SELECT MAX(id) AS max_id FROM une_table;

-- Trouver une valeur min dans une colonne
SELECT MIN(id) AS min_id FROM une_table;

-- Having [comme WHERE mais pour les fonctions (COUNT, AVG, SUM, MAX, MIN)]
SELECT COUNT(id) FROM une_table
HAVING COUNT(id) > 1;

-- Faire une jointure entre deux tables
SELECT * FROM une_table
LEFT JOIN autre_table ON une_table.id = autre_table.id;

-- Faire une jointure entre deux tables avec une condition
SELECT * FROM une_table
LEFT JOIN autre_table ON une_table.id = autre_table.id
WHERE une_table.nom = 'AAA';

-- Alterer une table (ajouter une colonne après une colonne donnée)
ALTER TABLE une_table
ADD COLUMN prix NUMERIC(7, 2) AFTER prenom;

-- Alterer une table (ajouter une colonne en première position)
ALTER TABLE une_table
ADD COLUMN prix NUMERIC(7, 2) FIRST;

-- Altérer une table (modifier une colonne en changeant son type)
ALTER TABLE une_table
MODIFY COLUMN prix DECIMAL(7, 2);

-- Altérer une table (modifier une colonne en changeant son nom)
ALTER TABLE une_table
CHANGE COLUMN prix prix_unitaire DECIMAL(7, 2);

-- Altérer une table (supprimer une colonne)
ALTER TABLE une_table
DROP COLUMN prix_unitaire;

-- Modifier une donnée
UPDATE une_table
SET nom = 'DDD';

-- Modifier une donnée avec une condition
UPDATE une_table
SET nom = 'DDD'
WHERE nom = 'AAA';