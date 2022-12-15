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

    if(n < 2):
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

for i in range (1000000000001, 1000000000011):
    print(decomp(i))