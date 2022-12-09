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


nom="perceuse visseuse"
prix=139.9
stock=5
image="no_photo.jpeg"
id_article=15
tuple_update = (nom,prix,stock,image,id_article)

sql = "UPDATE article SET nom=%s, prix=%s, stock=%s, image=%s WHERE id=%s"
print(sql)
mycursor.execute(sql, tuple_update)
mydb.commit()               # connection
print(mycursor.rowcount, "was updated.")


mydb.close()
