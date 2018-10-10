def dfs(graph, current, target, visited, rate):
    if current == target:
        return rate
    print(current)
    visited.add(current) 
    for i in graph[current]:
        if i[0] not in visited:
            return dfs(graph, i[0], target, visited, rate*i[1]) 
    return -1


E = int(input()) 
graph = {}
for _ in range(E):
    line = input().split() 
    if line[0] in graph:
        graph[line[0]].append([line[1], float(line[2])])
    else:
        graph[line[0]] = [[line[1], float(line[2])]]
    
    if line[1] in graph:
        graph[line[1]].append([line[0], float(1/float(line[2]))])
    else:
        graph[line[1]] = [[line[0], float(1/float(line[2]))]]



m = int(input()) 

for _ in range(m):
    line = input().split() 
    print(dfs(graph, line[0], line[1], set(), 1)) 