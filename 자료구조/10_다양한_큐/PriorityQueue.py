


# 우선순위 큐


class PriorityQueue:
    def __init__(self):
        self.items=[]
    
    def size(self):
        return len(self.items)
    
    def clear(self):
        self.items=[]

    def display(self, msg='PQueue:'):
        print(msg,self.items)

    def isEmpty(self):
        return len(self.items)==0
    
    def isFull(self):
        return False
    
    def enqueue (self, item):
        self.items.append(item)

    def findMaxIndex(self):
        if self.isEmpty() : return None
        else :
            highest= 0
            for i in range(1, self.size()):
                if self.items[i]>self.items[highest]:
                    highest = i
            return highest
            
            
    def dequeue ( self ) :
        highest = self.findMaxIndex()
        if highest is not None:
            return self.items.pop(highest)
        
    def peek(self):
        highest = self.findMaxIndex()
        if highest is not None:
            return self.items[highest]
        

if __name__=="__main__":
    print('<우선순위 큐(정렬되지 않는 리스트로 구현)>')
    pq=PriorityQueue()
    pq.enqueue(34)
    pq.enqueue(18)
    pq.enqueue(27)
    pq.enqueue(45)
    pq.enqueue(15)

    pq.display()
    while not pq.isEmpty() :
        print("Max priority = ", pq.dequeue())
