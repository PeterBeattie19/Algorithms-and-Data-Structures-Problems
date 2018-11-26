def collatx(n):
    if n==1: return 1
    if n%2 == 0: return 1 + collatx(int(n/2))
    return 1 + collatx(3*n + 1)

n = int(input()) 
mx = collatx(n) 

nums = list(map(int, list(str(n)))) 
print(nums)

for i in range(len(nums)):
    for j in range(1,10):
        tmp = list(nums)
        tmp[i] = j
        val = int("".join(list(map(str, tmp)))) 
        print(val)
        val = collatx(val)
        mx = max(mx, val) 

print(mx) 