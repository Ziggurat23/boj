#리스트로 구현한 그래프

#첫번째 방법 
#인접 정점 인덱스의 리스트

vertex1 = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']
adjList1 = [
[1, 2], # 'A'의 인접정점 리스트
[0, 3], # 'B'의 인접정점 리스트
[0, 3, 4], # 'C'의 인접정점 리스트
[1, 2, 5], # 'D'의 인접정점 리스트
[2, 6, 7], # 'E'의 인접정점 리스트
[3], # 'F'의 인접정점 리스트
[4, 7], # 'G'의 인접정점 리스트
[4, 6] # 'H'의 인접정점 리스트
]
graph1 = (vertex1, adjList1)


#두번째 방법 
#인접 정점 키의 리스트

vertex2 = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']
adjList2 = [
['B', 'C'], # 'A'의 인접정점 리스트
['A', 'D'], # 'B'의 인접정점 리스트
['A', 'D', 'E'], # 'C'의 인접정점 리스트
['B', 'C', 'F'], # 'D'의 인접정점 리스트
['C', 'G', 'H'], # 'E'의 인접정점 리스트
['D'], # 'F'의 인접정점 리스트
['E', 'H'], # 'G'의 인접정점 리스트
['E', 'G'] # 'H'의 인접정점 리스트
]
graph2 = (vertex2, adjList1)


#1,2번째 방법의 모든 정점의 인접 정점 개수 출력
def printDegree_AL1(graph):
    vlist = graph[0]          # 정점 리스트
    alist = graph[1]          # 인접 정점 리스트
    for i in range(len(vlist)):
        count = len(alist[i])  # 인접 정점의 수
        print(vlist[i], ":", count, end=' ')
    print()

print('AL1: ', end='')
printDegree_AL1(graph1)



#세번째 방법
#딕셔너리와 인접 리스트를 이용한 표현
graph3 = {
    'A': ['B', 'C'],  # A의 인접정점 B와 C
    'B': ['A', 'D'],  # B의 인접정점 A와 D
    'C': ['A', 'D', 'E'],  # C의 인접정점 A, D, E
    'D': ['B', 'C', 'F'],  # D의 인접정점 B, C, F
    'E': ['C', 'G', 'H'],  # E의 인접정점 C, G, H
    'F': ['D'],  # F의 인접정점 D
    'G': ['E', 'H'],  # G의 인접정점 E, H
    'H': ['E', 'G']  # H의 인접정점 E, G
}


#네번째 방법
#딕셔너리와 인접 집합을 이용한 표현(대괄호가 아니라 집합을 표현하는 중괄호 사용)
graph4 = {
    'A': {'B', 'C'},  # 정점 A, B와:C와 인접
    'B': {'A', 'D'},  # 정점 B, A와:D와 인접
    'C': {'A', 'D', 'E'},  # 정점 C, A와:D와:E와 인접
    'D': {'B', 'C', 'F'},  # 정점 D, B와:C와:F와 인접
    'E': {'C', 'G', 'H'},  # 정점 E, C와:G와:H와 인접
    'F': {'D'},  # 정점 F, D와 인접
    'G': {'E', 'H'},  # 정점 G, E와:H와 인접
    'H': {'E', 'G'}  # 정점 H, E와:G와 인접
}


# 3,4번째 방법의 모든 정점의 인접 정점 개수 출력
def printDegree_AL2(graph):  # graph: 딕셔너리 형식 (정점: 인접 정점들)
    for v in graph:  # 그래프의 모든 정점에 대해: 'A', ...
        count = len(graph[v])  # graph[v]: v의 인접 정점들
                               # 예) graph['A'] → ['B', 'C']
        print(v, ":", count, end=' ')
    print()

print('AL2: ', end='')
printDegree_AL2(graph4)

