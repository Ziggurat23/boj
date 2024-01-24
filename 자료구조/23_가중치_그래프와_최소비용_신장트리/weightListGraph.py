graphAL = {
    'A': {'B': 29, 'F': 10},
    'B': {'A': 29, 'C': 16, 'G': 15},
    'C': {'B': 16, 'D': 12},
    'D': {'C': 12, 'E': 22, 'G': 18},
    'E': {'D': 22, 'F': 27, 'G': 25},
    'F': {'A': 10, 'E': 27},
    'G': {'B': 15, 'D': 18, 'E': 25}
}

def weightSum(graph):
    sum = 0
    for v in graph:
        for e in graph[v]:
            sum += graph[v][e]
    return sum // 2

print('AL : weight sum =', weightSum(graphAL))


def printAllEdges(graph):
    for v in graph:
        for e in graph[v]:
            if v <= e:
                print("(%s,%s,%d)" % (v, e, graph[v][e]), end=' ')

printAllEdges(graphAL)
