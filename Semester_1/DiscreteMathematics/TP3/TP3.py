from math import *

def isPrime(n):
    if n == 1:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    d = 3
    while d*d <= n: # d*d <= n <==> d <= sqrt(n)
        if n % d == 0:
            return False
        else:
            d += 2
    return True

# print(isPrime(2))
# print(isPrime(3))
# print(isPrime(5))
# print(isPrime(15))
# print(isPrime(198688190101))

def iThPrime(n):
    if n == 1:
        return 2

    count = 1
    test = 1

    while count != n:
        test += 2
        if isPrime(test):
            count += 1
    return test

# print(iThPrime(100000))

def decomp(n):
    tab = []

    if n < 2:
        return False

    while (n % 2 == 0): # boucle pour les 2
        n //= 2
        tab.append(2)
    if n == 1:
        return tab

    d = 3
    while(d * d <= n): # boucle pour les impairs
        while(n % d == 0):
            n //= d
            tab.append(d)
        d += 2
    tab.append(n)
    return tab

# for i in range (1000000000001, 1000000000011):
#     print(decomp(i))

def racine(n):
    a = 1
    b = n
    if b < 2:
        return False

    while (b % 4 == 0): # boucle pour les 2
        b //= 4
        a *= 2

    d = 3
    while(d * d <= b): # boucle pour les impairs
        if b%(d*d) == 0:
            b //= d*d
            a *= d
        else:
            d += 2
    return a, b

# print(racine(56))
# print(racine(36))
# print(racine(13))
# print(racine(32))
# print(racine(5866080))

def pgcd(a, b):
    tabA = decomp(a)
    tabB = decomp(b)
    p = 1

    # Corrigé

    for i in tabA:
        if i in tabB:
            p *= i
            tabB.remove(i)
    return p

    # ========= Mon Algo =========
    # i = 0
    # j = 0
    # while i < len(tabA):
    #     while j < len(tabB):
    #         if tabA[i] == tabB[j]:
    #             p *= tabB[j]
    #             break
    #         j += 1
    #     i += 1
    # if p == 2 or p == 1:
    #     return p
    # if p != 1:
    #     return p // 2
    # ========= ========= =========

# print(pgcd(12, 18))
# print(pgcd(2, 2))
# print(pgcd(45, 28))
# print(pgcd(4488, 18876))
# print(pgcd(2074, 96))