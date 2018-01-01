s = input()

r = 0 #how many going to the right

count = 0

for i in s:
    if i == '>':
        r += 1
    if  i == '<':
        count += r*2
        
print(count)
