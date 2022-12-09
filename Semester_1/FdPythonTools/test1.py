def checkDivisiblePar2(nb):
    for i in range(0, 9, 2):
        if str(nb)[-1] == str(i):
            print("nombre divisible par 2")
            return

    print("nombre non divisible par 2")

def checkDivisiblePar5(nb):
    if str(nb)[-1] == str(0) or str(nombre)[-1] == str(5):
        print("nombre divisible par 5")
        return
    
    print("nombre non divisible par 5")

def checkDivisiblePar10(nb):
    if str(nb)[-1] == str(0):
        print("nombre divisible par 10")
        return

    print("nombre non divisible par 10")

def checkDivisiblePar3Ou9(nb):
    somme = nb

    while len(str(somme)) > 1:
        oldSomme = somme
        somme = 0
        somme = sum(int(chiffre) for chiffre in str(oldSomme))

    if somme == 9 or somme == 6 or somme == 3:
        if somme == 9:
            print("nombre divisible par 9")
        else:
            print("nombre divisible par 3")
        return

    print("nombre non divisible par 3 ou 9")

def checkDivisiblePar11(nb):
    chiffres = ""
    somme = nb
    j = 0

    while len(str(somme)) > 1:
        if len(str(somme)) == 2 and str(somme)[0] == "-":
            break;

        chiffres = str(somme)
        somme = 0
        # somme = sum(int(chiffres[i]) - int(chiffres[i+1]) for i in range(0, len(chiffres), 2))

        if chiffres[0] == "-":
            chiffres =  chiffres[1:]
        
        for i in range(0, len(chiffres), 2):
            try:
                somme += int(chiffres[i]) - int(chiffres[i+1])
            except:
                somme += int(chiffres[i])

    if somme % 11 == 0:
        print("nombre divisible par 11")
    else:
        print("nombre non divisible par 11")

nombre = input("entrez nombre : ")

checkDivisiblePar2(nombre)
checkDivisiblePar5(nombre)
checkDivisiblePar10(nombre)

checkDivisiblePar3Ou9(nombre)

checkDivisiblePar11(nombre)
