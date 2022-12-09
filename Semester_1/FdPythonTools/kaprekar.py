import math

def kaprekar(n, y):
    nExp = str(int(math.pow(n, y)))

    while len(nExp) % y != 0:
        nExp = "0" + nExp
    
    arr = []

    min = 0
    max = len(nExp)//y
    
    for i in range(y):
        offset = slice(min, max)

        arr.append(nExp[offset])

        min = max
        max += len(nExp)//y
    
    somme = sum(int(k) for k in arr)

    return somme == n

nombre = int(input("Entrez nombre : "))
if kaprekar(nombre, 2):
    print("Nombre Kaprekar")
elif kaprekar(nombre, 3):
    print("Nombre kaprekar triple")
elif kaprekar(nombre, 4):
    print("Nombre kaprekar quadruple")
else:
    print("Nombre non Kaprekar")

max = int(input("Liste kaprekar jusqu'à : "))
for i in range(1, max+1):
    if kaprekar(i, 2):
        print(f"{i} est Kaprekar")
    else:
        print(f"{i} est non Kaprekar")
