#! /usr/bin/python
# -*- coding:utf-8 -*-

import pymysql.cursors

mydb = pymysql.connect(    #pymysql.connect remplace mysql.connector
  host="localhost",   #localhost sur les machines perso.
  user="ehumber4",
  password="1407",
  database="BDD_ehumber4",
  charset='utf8mb4',                   # 2 attributs à ajouter
  cursorclass=pymysql.cursors.DictCursor  # 2 attributs à ajouter
)

mycursor = mydb.cursor()

libelle="Jardinage xxxx"

tuple_insert = (libelle,)

sql ="INSERT INTO type_article(libelle) VALUES (%s);"
print(sql)

mycursor.execute(sql, tuple_insert)
mydb.commit()
print("Tuple ajouté avec succès dans la table article avec id = ", mycursor.lastrowid)


mydb.close()