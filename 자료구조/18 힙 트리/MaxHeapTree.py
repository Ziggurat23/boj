class MaxHeap:                        #최대힙 클래스
    def __init__(self, capacity =10 ): #생성자정의
        self.capacity=capacity
        self.heap = [None]*(capacity+1) # 0번째 인덱스는 사용하지않기로 정의
        self.hsize=0

    def size(self):
        return self.hsize
    
    def isEmpty(self):
        return self.size()==0
    
    def isFull(self):
        return self.size()== self.capacity
    
    def Parent(self, i):
        return self.heap[i//2]
    
    def Left(self, i):
        return self.heap[i*2]
    
    def Right(self, i):
        return self.heap[i*2+1]
    
    def insert(self, n) :
        self.hsize += 1                 # 노드 개수 증가
        self.heap[self.size()] = n      # 맨 마지막 노드에 새로운 값 저장
        i = self.size()                 # 노드의 위치
        while (i != 1 and n > self.Parent(i)): # 부모보다 큰 도일 값일 경우
            self.heap[i] = self.Parent(i)      # 부모를 현재노드로
            i = i // 2                         # i를 부모의 인덱스로 옮김
        self.heap[i] = n               # 마지막 위치에 n 저장

    def delete(self) :
        parent = 1                    # 부모의 인덱스
        child = 2                     # 부모의 왼쪽 자식 인덱스
        if not self.isEmpty() :
            hroot = self.heap[1]      # 힙의 뿌리값을 삭제한 값
            last = self.heap[self.size()] # 마지막 노드
            while (child <= self.size()): # 마지막 노드까지 아래로 내려간다
                # 만약 오른쪽 노드가 더 큰 경우 child를 1 증가(오른쪽 인덱스)
                if child < self.size() and self.Left(parent) < self.Right(parent):
                    child += 1
                if last > self.heap[child] : # 자식이 더 작으면: 멈춤
                    break
                # 아니면 down-heap 계속 진행
                self.heap[parent] = self.heap[child]   # child를 부모에 복사
                parent = child                         # parent, child 교체
                child *= 2

            self.heap[parent] = last               # last를 parent위치에 복사
            self.hsize -= 1                        # last를 삭제
            return hroot                           # 삭제하였던 뿌리값 반환

    def peek(self):
        return self.heap[1]
    
    def display(self, msg = 'Heap: '):
        print(msg,self.heap[1:self.size()+1])   



heap = MaxHeap()                 # MaxHeap 객체 생성
data = [2, 5, 4, 8, 9, 3, 7, 3]    # 예제 입력 데이터
print("입력 --> ", data)

for elem in data:                # 모든 데이터를
    heap.insert(elem)            # 힙에 삽입
    heap.display('-')            # 현재 힙의 모습을 출력

print("삭제 --> ", heap.delete()) # 첫 삭제
heap.display('-')                # 현재 힙의 모습을 출력

print("삭제 --> ", heap.delete()) # 첫 삭제
heap.display('-')                # 현재 힙의 모습을 출력


