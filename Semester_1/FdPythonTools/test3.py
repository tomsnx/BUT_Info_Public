def aliquote(k):
    return [i for i in range(1, k) if not k % i]

def amicaux(m, n):
    return sum(aliquote(m)) == n and sum(aliquote(n)) == m

def premiers(m, n):
    if len(aliquote(m)) <= 1 or len(aliquote(n)) <= 1:
        print("Les deux nombres sont premiers entre eux")
        return

    for i in aliquote(m):
        for j in aliquote(n):
            if i == j:
                print("Les deux nombres ne sont pas premiers entre eux")
                return

    print("Les deux nombres sont premiers entre eux")

def amiPotentiel(n):
    return sum(aliquote(n))

n1 = input("premier nombre : ")
n2 = input("deuxième nombre : ")

if (amicaux(int(n1), int(n2))):
    print("Amicaux")
else:
    print("Pas amicaux")

premiers(int(n1), int(n2))

n3 = input("cherchez l'ami potentiel d'un nombre : ")
ami = amiPotentiel(int(n3))
print(f"l'ami potentiel de {n3} est {ami}")
if (amicaux(int(n3), int(ami))):
    print(f"{n3} et {ami} sont amicaux")
else:
    print(f"{n3} et {ami} ne sont pas amicaux")

n4 = input("liste nombres amicaux jusqu'à : ")
for i in range(1, int(n4)):
    for j in range(1, int(n4)):
        if (amicaux(int(i), int(j))):
            print(f"{i} et {j} amicaux")
