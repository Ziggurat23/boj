INF = 9999                   # 무한대
def getMinVertex(dist, selected):   
    minV = 0                 # dist[v]: 시작점에서 v까지의 거리
    mindist = INF            # dist가 최소인 정점을 인덱스 저장
    for v in range(len(dist)):
        if selected[v] == False and dist[v] < mindist:   # 선택되지 않은 정점 중에서 dist가 최소인 정점 선택
            mindist = dist[v]
            minV = v
    return minV              # dist가 최소인 정점의 인덱스 반환

def MSTPrim(vertex, adj):
    vsize = len(vertex)          # 정점의 수
    dist = [INF] * vsize         # 최소신장트리의 거리
    selected = [False] * vsize   # 최소신장트리(MST) 여부
    dist[0] = 0                  # 초기 정점에서 시작

    for i in range(vsize):       # 시작부터 모든 정점의 선택여부 확인
        u = getMinVertex(dist, selected)   # 최소 거리값 가진 정점 선택
        selected[u] = True       # MST에 포함 표시
        print(vertex[u], end=' ')

        for v in range(vsize):   # 모든 정점에 대해 dist 갱신
            if (adj[u][v] != None):         # (u,v)가 연결되어 있으면
                if not selected[v] and adj[u][v] < dist[v]:   # MST에 포함되지 않았고, 현재의 거리값보다 dist[v] 값이 작으면
                    dist[v] = adj[u][v]

    print()


vertex = ['A', 'B', 'C', 'D', 'E', 'F', 'G']
weight = [
    [None,   29, None, None, None,   10, None],
    [  29, None,   16, None, None, None,   15],
    [None,   16, None,   12, None, None, None],
    [None, None,   12, None,   22, None,   18],
    [None, None, None,   22, None,   27,   25],
    [  10, None, None, None,   27, None, None],
    [None,   15, None,   18,   25, None, None]
]

print("MST By Kruskal's Algorithm")
MSTPrim(vertex,weight)
