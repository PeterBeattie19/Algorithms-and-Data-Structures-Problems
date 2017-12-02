import math

def isPrime(value):
    if value == 1:
        return False
    if value == 2:
        return True

    for i in range(2,int(math.sqrt(value)+1)):
        if value%i == 0:
            return False
    return True

def findSol(num):
    i = num+1
    while True:
        if isPrime(i):
            return i
        i += 1

while True:
    try:
        n = int(input())
        if n == 0:
            break

        nPrime = isPrime(n)

        small = findSol(2*n)

        if not nPrime:
            print(small, end='')
            print(" (",end='')
            print(n, end='')
            print(" is not prime)")
        else:
            print(small)
    except EOFError:
        break
