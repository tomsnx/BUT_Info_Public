import math

def checkNombreNarcissique(nb):
    somme = sum(math.pow(int(i), len(str(nb))) for i in str(nb))

    if somme == nb:
        # print("nombre narcissique")
        return True
    else:
        # print("nombre non narcissique")
        return False

def listeNombreNarcissique(offset):
    for i in range(offset):
        if (checkNombreNarcissique(i)):
            print(f"{i} est narcissique")

# nombre = input("Entrez votre nombre : ")
offset = input("Liste des nombres narcissiques jusqu'à : ")

# checkNombreNarcissique(int(nombre))
listeNombreNarcissique(int(offset))