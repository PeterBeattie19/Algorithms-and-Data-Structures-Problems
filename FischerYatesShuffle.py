import random 

def swap(a,x1,x2):
  temp = a[x2]
  a[x2] = a[x1]
  a[x1] = temp

arr = [1,2,3,4,5,6,7,8,9,10]

print(arr)
for i in range(len(arr)-1,-1,-1):
  k = random.randint(0,i)
  swap(arr,i,k)

print(arr)
