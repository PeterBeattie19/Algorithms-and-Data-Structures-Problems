k = int(input()) 
x = list(map(int, input().split())) 
print(set([tuple(sorted([i, abs(i-k)])) for i in list(filter(lambda y: k-y in set(x), x))])) 