from Node import Node
class CircularLinkedQueue:
    def __init__(self):
        self.tail=None
        self.count =0 
    
    def size(self): return self.count
    def isEmpty(self): return self.tail==None
    def isFull(self): return False

    def enqueue(self , item):
        node = Node(item,None)
        if self.isEmpty():
            self.tail=node
            node.link=node
        else:
            node.link = self.tail.link
            self.tail.link=node
            self.tail = node
        self.count+=1

    def dequeue(self):
        if not self.isEmpty():
            self.count-=1
            data=self.tail.link.data
            if self.tail.link==self.tail :
                self.tail =None
            else :
                self.tail.link=self.tail.link.link
            return data
        
    def size_iter(self):
        if self.isEmpty() : return 0

        else :
            count = 1
            node = self.tail.link
            while not node == self.tail :
                node = node.link
                count+=1
            return count
        
    # def display(self, msg='CLQueue :'):

    #     print(msg, end= '= [')
    #     count = self.size_iter()
    #     for i in range(count):
    #         print(self..data[(self.front+1+i)%self.capacity], end=' ,')
    #     print(']')
    def display(self, msg='CLQueue:'):
        print(msg, end='= [')
        
        if not self.isEmpty():
            node = self.tail.link  # tail의 다음 노드부터 시작
            while True:            # 처음에 이미 node가 self.tail.link와 동일하기때문에 시작하기 위한 조건
                print(node.data, end=', ')
                node = node.link
                if node == self.tail.link:  # tail의 다음 노드로 돌아왔을 때 종료
                    break
        print(']')  

        
#==========================================
if __name__=="__main__":
    print('원형큐 테스트')
    q=CircularLinkedQueue()
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
    