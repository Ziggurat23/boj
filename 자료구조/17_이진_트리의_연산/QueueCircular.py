            # 큐의 예시) 버퍼링
            # 프린터와 컴퓨터 사이의 인쇄작업 (이 또한 버퍼링)
            # 실시간 비디오 스트리밍에서의 버퍼링
            # 시뮬레이션의 대기열 ( 공항 비행기, 은행 대기열)
            # 통신에서의 데이터 패킷들의 모델링에 사용
            # 서비스 센터의 콜큐 등등
            #
            # 파이썬에서 제공하는 queue 모듈에서는 
            # 스택은 LifoQueue, 큐는 Queue
            # 삽입은 push(),enqueue() --> put()
            # 삭제는 pop(), dequeue() --> get()


class CircularQueue:
    def __init__(self, capacity =10):
        self.capacity= capacity
        self.front=0
        self.rear=0
        self.items=[None]*self.capacity

    def isEmpty ( self ):
        return self.front == self.rear

    def isFull(self):
        return self.front==(self.rear+1)%self.capacity
    
    def size(self) :
        return (self.rear - self.front + self.capacity) % self.capacity

    def enqueue ( self , item):
        if not self.isFull():
            self.rear = ( self.rear +1 ) % self.capacity
            self.items[self.rear]=item

    def clear ( self ) :
        self.front = self.rear


    def dequeue ( self):
        if not self.isEmpty():
            self.front=(self.front+1)%self.capacity
            return self.items[self.front]

    def peek(self):
        if not self.isEmpty():
            return self.items[(self.front+1)%self.capacity]
        
    def display(self, msg='Queue :'):
        print(msg, end= '= [')
        count = self.size()
        for i in range(count):
            print(self.items[(self.front+1+i)%self.capacity], end=' ,')
        print(']')

#========================================================================

if __name__=="__main__":
    print('원형큐 테스트')
    q=CircularQueue()
    for i in range(9):
        q.enqueue(i)
    q.display(' enqueue()*9 :')
    print('dequeue()-->',q.dequeue())
    print('dequeue()-->',q.dequeue())
    print('dequeue()-->',q.dequeue())
    q.display('dequeue()*3 : ')
    
    q.enqueue('홍길동')
    q.enqueue('이순신')
    q.enqueue('김연아')
    q.display(' enqueue()*3 :')
    print('dequeue()-->',q.dequeue())
    q.display('dequeue()*1 : ')
    print(' peek() --> ', q.peek())