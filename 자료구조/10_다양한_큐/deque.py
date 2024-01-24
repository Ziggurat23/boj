# 덱에서 삽입과 삭제를 양쪽 모두에서 가능
# 중간에서 넣거나 빼는 것은 못함 (리스트만 가능)
# 큐, 스택과 비슷한 연산이 많음

# 스택의 push(), 큐의 enqueue() -> add rear()
# 스택의 pop() -> delete rear()
# 큐의 dequeue() -> delete front()
# 스택의 peek() -> get rear()
# 큐의 peek() -> get front()


from QueueCircular import CircularQueue


class CircularDeque(CircularQueue):
    def __inin__(self, capacity=10):
        super().__init__(capacity)




    

    
    def addRear(self, item):
        self.enqueue(item)
    
    def deleteFront(self):
        return self.dequeue()
    
    def getFront(self):
        return self.peek()
    
    def addFront(self, item):
        if not self.isFull():
            self.items[self.front] = item
            self.front = (self.front - 1 + self.capacity)%self.capacity
    
    def deleteRear(self):
        if not self.isEmpty():
            item = self.items[self.rear]
            self.rear = (self.rear - 1 + self.capacity)%self.capacity
            return item
        
    def getRear(self):
        return self.items[self.rear]





#파이썬의 collections의 모듈 deque클래스가 있음
import collections
#후단 삽입 삭제 append / pop
#전단 삽입 삭제 appendleft/ popleft
#peek 제공하지않음

#========================================================
if __name__=="__main__":
    #========================================================
    print('<원형덱 테스트>')
    dq=CircularDeque(100)

    for i in range(9):
        if i%2==0 : dq.addRear(i)
        else : dq.addFront(i)
    dq.display('홀수(전단),짝수(후단) 삽입 : ')

    for i in range(2):
        dq.deleteFront()

    for i in range(3):
        dq.deleteRear()
    
    dq.display("전단 2번, 후단 3번 삭제 연산 :")

    for i in range(9,14):
        dq.addFront(i)
    dq.display("전단 9~13 삽입")
    dq.getFront()
 #========================================================
    print('\n<파이썬 collections모듈의 deque 테스트>')
    cdq = collections.deque()

    for i in range(9):
        if i%2==0 : cdq.append(i)
        else : cdq.appendleft(i)
    print('홀수(전단),짝수(후단) 삽입 : ', cdq)


    for i in range(2):
        cdq.popleft()
    for i in range(3):
        cdq.pop()
    print("전단 2번 삭제 , 후단 3번 삭제", cdq)

    for i in range(9,14):
        cdq.appendleft(i)
    print("전단 9~13 삽입" , cdq)
