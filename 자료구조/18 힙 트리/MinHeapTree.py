
#파이썬에서 제공하는 최소힙 함수
import heapq
data = [2, 5, 4, 8, 9, 3, 7, 3]    # 예제 입력 데이터
print('입력배열 : ',data)
heapq.heapify(data)
print('최소 힙 : ', data)
print(heapq.heappop(data))
print(heapq.heappop(data))
print(heapq.heappop(data))
print('최소 힙 : ',data)