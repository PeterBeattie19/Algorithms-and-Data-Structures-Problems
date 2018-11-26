import numpy as np
odds = [1.04, 11.0, 67.0, 81.0, 251.0, 501.0] 
odds = list(map(lambda x: 1/x, odds)) 
odds = list(map(lambda x: x/sum(odds), odds)) 
people = list("ABCDEF")
c = 0
num_sim = 50000
for _ in range(num_sim):
    if set(np.random.choice(people, size = len(people), replace = False, p = odds)[-3:]) == set(list("BCF")):
        c += 1
print(float(c/num_sim)*100) 