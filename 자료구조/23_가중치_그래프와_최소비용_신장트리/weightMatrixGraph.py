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

def weightSum(vlist, w):
    sum = 0  # 가중치의 합
    for i in range(len(vlist)):  # 모든 정점에 대해 (i: 0, ..., N-1)
        for j in range(i+1, len(vlist)):  # 하나씩 앞에 대해 (상삼각형 영역)
            if w[i][j] != None:  # 마주한 정점이 있으면
                sum += w[i][j]  # sum에 추가
    return sum  # 전체 가중치 합을 반환

print('AM : weight sum = ', weightSum(vertex, weight))


def printAllEdges(vlist, w):
    for i in range(len(vlist)):  # 모든 정점에 대해
        for j in range(i+1, len(vlist)):  # 모든 간선 W[i][j]에 대해
            if w[i][j] != None and w[i][j] != 0:  # 간선이 있으면
                print("(%s,%s,%d) " % (vlist[i], vlist[j], w[i][j]), end=' ')  # 출력
    print()

printAllEdges(vertex, weight)
