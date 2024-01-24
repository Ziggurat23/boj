from DNode import DNode

class DoublyLinkedDeque:
    def __init__(self):
        self.front=None
        self.rear=None
        self.count=0


    def isEmpty(self): return self.front==None
    def isFull(self): return False
    def clear(self):
        self.front = self.rear = None
        self.count = 0

    
    def addFront(self,item):
        node = DNode ( item, None,self.front)
        if (self.isEmpty()):
            self.front=self.rear=node
        else:
            self.front.prev=node
            self.front = node
        self.count+=1

    def addRear( self, item ):
        node = DNode(item, self.rear, None)
        if( self.isEmpty()):
            self.front = self.rear = node
        else :
            self.rear.next = node
            self.rear =node
        self.count += 1


        
    def deleteFront(self):
        if not self.isEmpty():
            self.count -= 1
            data = self.front.data
            self.front=self.front.next
            if self.front==None:
                self.rear=None
            else:
                self.front.prev=None
            return data

    def deleteRear(self):
        if not self.isEmpty():
            self.count -=1
            data = self.rear.data
            self.rear = self.rear.prev

            if self.rear==None:
                self.front=None
            else:
                self.rear.next=None
            return data
    def display(self, msg='DoublyLinkedQueue :'):
        print(msg, end= ' ')
        node= self.front
        while not node== None:
            print(node.data,end=' ')
            node=node.next
        print()
#========================================================
if __name__=="__main__":
    print('<원형덱 테스트>')
    dq=DoublyLinkedDeque()

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
