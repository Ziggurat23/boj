def dfs_cc(graph, color, v, visited):
    if v not in visited:                          # 아직 방문하지 않은 정점인 경우
        visited.add(v)                            # 해당 정점을 방문했음을 표시
        color.append(v)                           # 현재 컴포넌트에 정점을 추가
        nbr = graph[v] - visited                  # nbr: 인접한 정점
        for u in nbr:                             # u ∈ {인접정점} - {방문정점}
            dfs_cc(graph, color, u, visited)      # 재귀 호출

def find_connected_component(graph):
    visited = set()                               # 방문한 정점을 기록
    colorList = []                                # 연결된 각 컴포넌트를 저장할 리스트

    for vtx in graph:
        if vtx not in visited:                    # 아직 방문하지 않은 정점인 경우
            color = []                            # 새 컴포넌트 생성
            dfs_cc(graph, color, vtx, visited)    # 현재 컴포넌트의 모든 정점을 찾음
            colorList.append(color)               # 현재 컴포넌트를 리스트에 추가

    print("그래프 연결성분 개수 = %d" % len(colorList))
    print(colorList)


mygraph = {
    "A" : set(["B", "C"]),
    "B" : set(["A"]),
    "C" : set(["A"]),
    "D" : set(["E"]),
    "E" : set(["D"])
}

print('find_connected_component: ')
find_connected_component(mygraph)

