import sys

def dernierChiffre(n):
    if n < 0:
        n = -n

    return n % 10

def deuxDerniersChiffres(n):
    if n < 0:
        n = -n

    return n % 100

def derniersChiffres(n, nbre):
    if n < 0:
        n = -n

    return n % (10**nbre)

def nombreChiffres(n):
    if n < 0:
        n = -n

    res = 0

    while n != 0:
        n //= 10
        res += 1

    return res

def premierChiffre(n):
    if n < 0:
        n = -n

    while n >= 10:
        n //= 10

    return n

def premiersChiffres(n, nbre):
    if n < 0:
        n = -n

    r = abs(nombreChiffres(n) - nbre)

    for _ in range(r):
        n //= 10

    return n

def chiffres (n, debut, fin):
    n = premiersChiffres(n, fin)
    n = derniersChiffres(n, fin-debut+1)

    return n

def quotient(a, b):
    if b == 0:
        print("erreur")
        return

    q = 0

    while a >= b:
        a -= b
        q += 1

    return q

def reste(a, b):
    if b == 0:
        print("erreur")
        return

    while a >= b:
        a -= b

    return a

def div(a, b):
    if b == 0:
        print("erreur")
        return

    q = 0

    while a >= b:
        a -= b
        q += 1

    return q, a

def quotient2(a, b):
    if b == 0:
        print("erreur")
        return

    q, r = div(abs(a), abs(b))

    if r > 0:
        if a >= 0 and b > 0:
            return q
        if a >= 0 and b < 0:
            return -q
        if a < 0 and b > 0:
            return -q-1
        if a < 0 and b < 0:
            return q+1
    else:
        if a*b >= 0:
            return q
        else:
            return -q

def reste2(a, b):
    if b == 0:
        print("erreur")
        return

    r = reste(abs(a), abs(b))

    if r > 0:
        if a >= 0:
            return r
        if a < 0 and b > 0:
            return b-r
        if a < 0 and b < 0:
            return -b-r
    else:
        return r

def div2(a, b):
    if b == 0:
        print("erreur")
        return

    q, r = div(abs(a), abs(b))

    if r > 0:
        if a >= 0 and b > 0:
            return q, r
        if a >= 0 and b < 0:
            return -q, r
        if a < 0 and b > 0:
            return -q-1, b-r
        if a < 0 and b < 0:
            return q+1, -b-r
    else:
        if a*b >= 0:
            return q, r
        else:
            return -q, r

def puissance(a, b, c):
    res = 1
    for _ in range(b):
        res *= a
        res = (res % c)
        # res = (res*a)%c

    return res

def puissance2(a, b, c):
    if b == 0:
        return 1
    if b == 1:
        return a

    if b % 2 == 0:
        res = puissance2(a, b//2, c)
        return (res * res) % c

    if b % 2 > 0:
        res = puissance2(a, b//2, c)
        return (res * res * a) % c

import math

def puissance3(a, b, c):
    a %= c
    tab = []
    res = 1

    while res not in tab:
        tab.append(res)
        res = (res*a)%c

    deb = tab.index(res)
    longcycle = len(tab) - deb

    if b < deb:
        return tab[b]
    else:   # b >= deb
        b = b%longcycle
        i = deb
        while b != i%longcycle:
            i += 1
        return tab[i]
    

print(puissance3(1037, 10**1000000, 52420000))