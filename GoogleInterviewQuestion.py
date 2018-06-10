total = int(input())
arr = list(map(int, input().split()))

mp = {}

for i in range(len(arr)):
	mp[arr[i]] = i

#arr = [1,2,3,4,5,6], mp = {1:0,2:0,....,6:5}
p1 = 0
p2 = 0

for i in range(len(arr)):
	if arr[i] < total and (total - arr[i]) in mp and mp[total-arr[i]] != i:
		p1 = arr[i]
		p2 = total-arr[i] 
		break

print(p1,p2) 