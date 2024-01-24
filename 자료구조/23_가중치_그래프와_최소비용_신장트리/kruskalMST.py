#최소 신장 트리(Minimum Spanning Tree, MST)
parent = []          # 각 노드의 부모를 저장하는 리스트
set_size = 0         # 전체 노드 집합의 개수

def init_set(nSets):
    global set_size, parent
    set_size = nSets
    for i in range(nSets):
        parent.append(-1)  # 각 원소는 자기 자신을 부모로 초기 설정

def find(id):
    while parent[id] >= 0:  # 부모가 자기 자신이 아닐 동안
        id = parent[id]     # 부모를 찾아 올라간다
    return id              # 최종 루트(대표원소)를 반환

def union(s1, s2):
    global set_size
    parent[s1] = s2       # s1의 부모를 s2로 설정
    set_size = set_size - 1  # 집합의 개수 감소


def MSTKruskal(vertex, adj): 
    vsize = len(vertex)         # 그래프의 정점 개수
    init_set(vsize)             # 집합 초기화
    eList = []                  # 간선 리스트

    for i in range(vsize-1):    # 모든 그래프의 간선에 대하여
        for j in range(i+1, vsize):
            if adj[i][j] != None:   # 연결된 간선
                eList.append((i,j,adj[i][j]))  # 간선 추가

    eList.sort(key=lambda e: e[2], reverse=True) # (1) 간선 리스트를 가중치 내림차순으로 정렬

    edgeAccepted = 0
    while (edgeAccepted < vsize - 1): # n - 1개의 간선
        e = eList.pop(-1) # (2) 가장 작은 가중치를 가진 간선을 뽑는다
        uset = find(e[0]) # 두 정점이 속한 집합을 찾는다
        vset = find(e[1])
        # (3) 사이클이 생기면 무시하고 다시 반복한다
        # (4) 사이클이 생기지 않으면 MST에 추가
        if uset != vset: # 두 정점이 다른 집합에 속한다면
            print("간선 추가 : (%s, %s, %d)" % (vertex[e[0]], vertex[e[1]], e[2])) # MST에 간선 추가
            union(uset, vset) # 두 집합을 합친다
            edgeAccepted += 1 # 간선이 하나 추가됨
        # (5) n-1개의 간선이 선택될 때까지 반복

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
MSTKruskal(vertex,weight)
