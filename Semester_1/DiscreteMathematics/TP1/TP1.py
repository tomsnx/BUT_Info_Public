# factorielle(n)

def factorielle(n):
    if n == 0 or n == 1:
        return 1

    res = 2

    for i in range(3, n+1):
        res *= i
    
    return res

for i in range(0, 10):
    print(f"{i}! = {factorielle(i)}")


# absolue(x)

def absolue(x):
    if x < 0:
        x = -x
    return x

print(f"|-4| = {absolue(-4)}")
print(f"|0| = {absolue(0)}")
print(f"|9| = {absolue(9)}")

# u1(n)

def u1(n):
    res = 0

    for i in range(1, n+1):
        res += i
    
    return res

print(f"u1(0) = {u1(0)}")
print(f"u1(1) = {u1(1)}")
print(f"u1(2) = {u1(2)}")
print(f"u1(5) = {u1(5)}")
print(f"u1(-3) = {u1(-3)}")

# u2(n)

def u2(n):
    return (n*(n+1))//2

print(f"u2(0) = {u1(0)}")
print(f"u2(1) = {u1(1)}")
print(f"u2(2) = {u1(2)}")
print(f"u2(5) = {u1(5)}")
print(f"u2(-3) = {u1(-3)}")

# v(n)

def v(n):
    if (n < 0):
        return 0

    res = 1745

    for _ in range(0, n):
        res = 0.9972*res + 2123
    
    return res

# print(f"v(0) = {v(0)}")
# print(f"v(1) = {v(1)}")
# print(f"v(2) = {v(2)}")
# print(f"v(5) = {v(5)}")
# print(f"v(-3) = {v(-3)}")

# for i in range(99900, 100000):
#     print(f"v({i}) = {v(i)}")
# v semble strictement croissante; ralentissement : convergence ? confirmation à 100000 vers 758214.2857142583

# i = 10000
# while v(i+1) != v(i):
#     i += 1
# print(i) # stabilisation à 11096

# Exercice
for n in range(-10000000, 10000000):
    if (8*n + 1) % (3*n + 7) == 0:
        print(f"3n+7 divise 8n+1 quand n = {n}");
