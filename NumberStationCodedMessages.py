arr = list(map(int, input().split()))
t = int(input())


temp = 0
start = 0
fin = 0
i = 0
found = False

while i < len(arr):
    temp += arr[i]

    if temp == t:
        fin = i
        found = True
        break
    if temp > t:
        i = start
        start += 1
        temp = 0
    i += 1

if found == True:
    print(start,fin) 
        
else:
    print("-1 -1")
