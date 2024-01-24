def dfs(graph, v, visited):
    if v not in visited :
        visited.add(v)
        print(v, end=' ')
        nbr = graph[v] - visited

        for u in nbr:
            dfs(graph, u, visited)


import collections

def bfs(graph, start):
    visited = set([start])
    queue = collections.deque([start])
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        nbr = graph[v] - visited
        for u in nbr:
            visited.add(u)
            queue.append(u)

#신장 트리 알고리즘
def bfsST(graph, start):
    visited = set([start])
    queue = collections.deque([start])
    while queue:
        v = queue.popleft()
        nbr = graph[v] - visited #nbr = neighbor
        for u in nbr:
            print("(", v, ",", u, ")", end="")
            visited.add(u)
            queue.append(u)

mygraph = {
    "A" : {"B", "C"},
    "B" : {"A", "D"},
    "C" : {"A", "D", "E"},
    "D" : {"B", "C", "F"},
    "E" : {"C", "G", "H"},
    "F" : {"D"},
    "G" : {"E", "H"},
    "H" : {"E", "G"}
}

print('DFS : ', end='')
dfs(mygraph, "A", set())
print()

print('BFS : ', end='')
bfs(mygraph, "A")
print()

#신장 트리 알고리즘
bfsST(mygraph,"A")