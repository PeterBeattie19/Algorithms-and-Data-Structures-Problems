calc = lambda x: 1 + calc(int(x/2)) if x > 1 else 1
print(calc(7000000000))