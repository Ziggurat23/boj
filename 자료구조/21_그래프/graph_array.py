#배열로 구현한 그래프
vertex = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']
adjMat = [
    [0, 1, 1, 0, 0, 0, 0, 0],
    [1, 0, 0, 1, 0, 0, 0, 0],
    [1, 0, 0, 1, 1, 0, 0, 0],
    [0, 1, 1, 0, 0, 1, 0, 0],
    [0, 0, 1, 0, 0, 0, 1, 1],
    [0, 0, 0, 1, 0, 0, 0, 0],
    [0, 0, 0, 0, 1, 0, 0, 1],
    [0, 0, 0, 0, 1, 0, 1, 0]
]
graph0 = (vertex, adjMat)



def printDegree_AM(graph):
    vlist = graph[0]          # 정점 리스트
    M = graph[1]              # 인접 행렬
    for i in range(len(vlist)):
        row = M[i]            # 행렬의 해당 행
        count = 0             # 인접 정점의 수 카운팅
        for e in M[i]:
            if e > 0: count += 1
        print(vlist[i], ":", count, end=' ')
        print()

print('AM : \n', end='')
printDegree_AM(graph0)