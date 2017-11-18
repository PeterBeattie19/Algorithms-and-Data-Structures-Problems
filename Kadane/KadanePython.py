arr = list(map(int, input().split()))

max = arr[1] - arr[0]

small = arr[0]

for i in arr[1:]:
    if(i - small) > max:
        max = i - small
    if i < small :
        small = i

print(max) 
