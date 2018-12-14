from functools import reduce
from itertools import combinations, chain

def subsets(s): 
    return list(map(list, list(chain(*map(lambda x: combinations(s, x), range(1, len(s)+1))))))

def divs(n):
    return list(filter(lambda x: n%x == 0, list(range(2,101)))) 

x, y = map(int, input().split())

x_combo, y_combo = subsets(divs(x)), subsets(divs(y)) 

x_possible, y_possible = list(filter(lambda c: reduce(lambda a,b: a*b, c) == x, x_combo)), list(filter(lambda c: reduce(lambda a,b: a*b, c) == y, y_combo)) 

for i in x_possible:
    for j in y_possible:
        if len(set(i) - set(j)) == len(set(i)):
            print(max(x,y)) 
            exit() 
print(min(x,y)) 
