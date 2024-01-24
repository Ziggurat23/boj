#위상정렬 알고리즘

def topological_sort_AM(vertex, graph) :
    n = len(vertex)
    inDeg = [0] * n          # 초기의 진입차수 설정
    for i in range(n) :
        for j in range(n) :
            if graph[i][j] > 0 :
                inDeg[j] += 1  # 진입차수를 1 증가시킴
    vlist = []               # 진입차수가 0인 정점 리스트 만들기
    for i in range(n) :
        if inDeg[i] == 0 :
            vlist.append(i)

    while len(vlist) > 0 :
        v = vlist.pop()                  # 리스트가 비어있지 않은 동안
        print(vertex[v], end=' ')        # 진입차수가 0인 정점을 하나 꺼냄

        for u in range(n) :
            if v != u and graph[v][u] > 0 :
                inDeg[u] -= 1            # 연결된 정점의 진입차수 감소
                if inDeg[u] == 0 :       # 진입차수가 0이면
                    vlist.append(u)      # vlist에 추가


vertex = ['A', 'B', 'C', 'D', 'E', 'F']
graphAM = [    
    [0, 0, 1, 1, 0, 0],
    [0, 0, 0, 1, 1, 0],
    [0, 0, 0, 1, 0, 1],
    [0, 0, 0, 0, 0, 1],
    [0, 0, 0, 0, 0, 1],
    [0, 0, 0, 0, 0, 0]
]

print('topological_sort_AM: ')
topological_sort_AM(vertex, graphAM)
print()