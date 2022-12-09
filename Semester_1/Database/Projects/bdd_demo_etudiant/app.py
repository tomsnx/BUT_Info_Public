#! /usr/bin/python
# -*- coding:utf-8 -*-
from flask import Flask, request, render_template, redirect, url_for, abort, flash, session, g
import pymysql.cursors

# application WSGI
# (interface de serveur web python)
# comportements et methodes d'un serveur web

app = Flask(__name__)    # instance de classe Flask (en parametre le nom du module)
app.secret_key = 'une cle(token) : grain de sel(any random string)'

def get_db():
    if 'db' not in g:
        g.db =  pymysql.connect(
            host="localhost",                 # à modifier
            user="login",                     # à modifier
            password="secret",                # à modifier
            database="BDD_votrelogin",        # à modifier
            charset='utf8mb4',
            cursorclass=pymysql.cursors.DictCursor
        )
    return g.db

@app.teardown_appcontext
def teardown_db(exception):
    db = g.pop('db', None)
    if db is not None:
        db.close()

articles = [
    {'id': 3, 'nom': 'Boite de rangement', 'type_article_id': 1, 'prix': 3, 'stock': 7, 'description': None, 'image': 'boites.jpeg'},
    {'id': 1, 'nom': 'Enveloppes (50p)', 'type_article_id': 1, 'prix': 2, 'stock': 1, 'description': None, 'image': None},
    {'id': 2, 'nom': 'Stylo noir', 'type_article_id': 1, 'prix': 1, 'stock': 10, 'description': None, 'image': 'stylo.jpeg', 'nb_avis': 4},
    {'id': 4, 'nom': 'Chaise', 'type_article_id': 2, 'prix': 40, 'stock': 2, 'description': None, 'image': 'chaise.jpeg'},
    {'id': 5, 'nom': 'Tables', 'type_article_id': 2, 'prix': 200, 'stock': 3, 'description': None, 'image': 'table.jpeg'},
    {'id': 6, 'nom': 'Salon de Jardin alu', 'type_article_id': 3, 'prix': 149, 'stock': 3, 'description': None, 'image': 'salonJardin2.jpg'},
    {'id': 8, 'nom': 'Set Table + 4 bancs', 'type_article_id': 3, 'prix': 229, 'stock': 2, 'description': None, 'image': 'setTableChaises.jpg'},
    {'id': 7, 'nom': 'Table+6 fauteuilles de Jardin', 'type_article_id': 3, 'prix': 790, 'stock': 3, 'description': None, 'image': 'tableFauteuilsJardin1.jpg'},
    {'id': 9, 'nom': 'arrosoir bleu', 'type_article_id': 4, 'prix': 14, 'stock': 2, 'description': None, 'image': 'arrosoir1.jpg', 'nb_notes': 1, 'moy_notes': '5.000000', 'nb_avis': 1},
    {'id': 10, 'nom': 'arrosoir griotte', 'type_article_id': 4, 'prix': 10, 'stock': 2, 'description': None, 'image': 'arrosoir2.jpg'}, 
    {'id': 11, 'nom': 'tuyau arrosage', 'type_article_id': 4, 'prix': 32, 'stock': 3, 'description': None, 'image': 'tuyauArrosage1.jpg'},
    {'id': 12, 'nom': 'tournevis', 'type_article_id': 5, 'prix': 24, 'stock': 3, 'description': None, 'image': 'lotTourneVis.jpg'},
    {'id': 13, 'nom': 'marteau menuisier', 'type_article_id': 5, 'prix': 8, 'stock': 3, 'description': None, 'image': 'marteau.jpg'}, 
    {'id': 14, 'nom': 'pince multiprise', 'type_article_id': 5, 'prix': 22, 'stock': 3, 'description': None, 'image': 'pinceMultiprise.jpg'},
    {'id': 15, 'nom': 'perceuse', 'type_article_id': 5, 'prix': 150, 'stock': 3, 'description': None, 'image': 'perceuse.jpg'}
  
]

types_articles = [
    {'id': 1, 'libelle': 'Fourniture de bureau'},
    {'id': 2, 'libelle': 'Mobilier'},
    {'id': 3, 'libelle': 'Mobilier Jardin'},
    {'id': 4, 'libelle': 'Arrosage'},
    {'id': 5, 'libelle': 'Outils'},
    {'id': 6, 'libelle': 'Divers'}
]

@app.route('/')
@app.route('/show/type-article')
def type_article_show():
    #print(types_articles)
    return render_template('type_article/type_article_show.html', types_articles=types_articles)

@app.route('/add/type-article', methods=['GET'])
def type_article_add():
    return render_template('type_article/type_article_add.html')

@app.route('/add/type-article', methods=['POST'])
def type_article_valid_add():
    libelle = request.form.get('libelle', '')
    print(u'type ajouté , libellé :', libelle)
    message = u'type ajouté , libellé :'+libelle
    flash(message, 'alert-success')
    return redirect('/show/type-article')
   

@app.route('/delete/type-article', methods=['GET'])
def type_article_delete():
    id = request.args.get('id', '')
    print ("un type d'article supprimé, id :",id)
    message=u'un type d\'article supprimé, id : ' + id
    flash(message, 'alert-warning')
    return redirect('/show/type-article')

@app.route('/edit/type-article', methods=['GET'])
def type_article_edit():
    id = request.args.get('id', '')
    libelle = request.args.get('libelle', '')     # comment passé plusieurs paramètres (clé primaire composés)
    id=int(id)
    type_article = types_articles[id-1]
    return render_template('type_article/type_article_edit.html', type_article=type_article)

@app.route('/edit/type-article', methods=['POST'])
def type_article_valid_edit():
    libelle = request.form['libelle']
    id = request.form.get('id', '')
    print(u'type article modifié, id: ',id, " libelle :", libelle)
    message=u'type article modifié, id: ' + id + " libelle : " + libelle
    flash(message, 'alert-success')
    return redirect('/show/type-article')

@app.route('/show/article')
def article_show():
    # print(articles)
    return render_template('article/article_show.html', articles=articles)

@app.route('/add/article', methods=['GET'])
def article_add():
    return render_template('article/article_add.html', types_articles=types_articles)

@app.route('/add/article', methods=['POST'])
def article_add_valid():
    nom = request.form.get('nom', '')
    type_article_id = request.form.get('type_article_id', '')
    prix = request.form.get('prix', '')
    stock = request.form.get('stock', '')
    description = request.form.get('description', '')
    image = request.form.get('image', '')
    print(u'article ajouté , nom: ', nom, ' - type_article_id :', type_article_id, ' - prix:', prix, ' - stock:', stock, ' - description:', description, ' - image:', image)
    message = u'article ajouté , nom:'+nom + '- type_article_id :' + type_article_id + ' - prix:' + prix + ' - stock:'+  stock + ' - description:' + description + ' - image:' + image
    flash(message, 'alert-success')
    return redirect('/show/article')

@app.route('/delete/article', methods=['GET'])
def article_delete():
    id = request.args.get('id', '')
    message=u'un article supprimé, id : ' + id
    flash(message, 'alert-warning')
    return redirect('/show/article')

@app.route('/edit/article', methods=['GET'])
def article_edit():
    id = request.args.get('id', '')
    id=int(id)
    article = articles[id-1]
    return render_template('article/article_edit.html', article=article, types_articles=types_articles)

@app.route('/edit/article', methods=['POST'])
def article_valid_edit():
    nom = request.form['nom']
    id = request.form.get('id', '')
    type_article_id = request.form.get('type_article_id', '')
    prix = request.form.get('prix', '')
    stock = request.form.get('stock', '')
    description = request.form.get('description', '')
    image = request.form.get('image', '')
    print(u'article modifié , nom : ', nom, ' - type_article_id :', type_article_id, ' - prix:', prix, ' - stock:', stock, ' - description:', description, ' - image:', image)
    message = u'article modifié , nom:'+nom + '- type_article_id :' + type_article_id + ' - prix:' + prix + ' - stock:'+  stock + ' - description:' + description + ' - image:' + image
    flash(message, 'alert-success')
    return redirect('/show/article')

if __name__ == '__main__':
    app.run()
