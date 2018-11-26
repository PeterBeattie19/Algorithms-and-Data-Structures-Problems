x = list(map(int, input().split())) 
print(list(map(lambda y: sum(x)-y, x))) 