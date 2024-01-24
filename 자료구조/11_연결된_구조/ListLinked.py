from Node import Node
from ArrayListClassBasic import ArrayList
class LinkedList:
    def __init__( self):
        self.head = None
        self.count = 0
    
    def size( self ) : return self.count

    def isEmpty( self ): return self.head==None

    def clear( self ) :
        self.head = None
        self.count = 0

    def getNode(self, pos) :             # 인덱스가 pos인 노드 반환
        if pos < 0 : return None         # None 반환
        if pos >= self.size() :          # 맨 뒤의 노드 반환
            pos = self.size()-1
        node = self.head
        while pos > 0 and node != None :
            node = node.link
            pos -=1
        return node
    
    def getEntry(self, pos) :    
        node = self.getNode(pos)         
        if node == None :
            return None
        else :
            return node.data             
        
    def size_iter( self ) :
        node = self.head
        count = 0
        while node is not None :
            node = node.link
            count += 1
        return count
    
    def display(self, msg='LinkedList:' ):
        print(msg, end="")
        node = self.head
        while node is not None :
            print(node.data, end="->")
            node = node.link
        print("None")
    
    def insert(self, pos, elem):
        before = self.getNode(pos-1)
        if before==None:
            self.head = Node(elem, self.head)
        else :
            node = Node(elem, before.link)
            before.link = node
        self.count+=1
    
    def delete(self, pos) :
        before = self.getNode(pos-1)
        if before == None :
            if self.head is not None :
                self.head = self.head.link
        else:
            before.link = before.link.link
        self.count -= 1

    def replace(self, pos, elem):
        # pos 위치의 노드를 찾는다.
        node = self.getNode(pos)
        if node is not None:
            # 해당 노드의 데이터 부분을 새 원소로 바꿔준다.
            node.data = elem
        else:
            print("해당 위치에 노드가 존재하지 않습니다.")

#======
if __name__ == "__main__" :
    s = LinkedList()
    s.display('연결 구조 구현한 리스트(LinkedList) 테스트 : ')
    s.insert(0,10)
    s.insert(0,20)
    s.insert(1,30)
    s.insert(s.size(),40)
    s.insert(2,50)
    s.display('삽입*5 : ')
    s.replace(2,90)
    s.display('교체*1 : ')
    s.delete(2)
    
    s.delete(s.size()-1)
    s.delete(0)
    s.display('삭제*3 : ')
    s.clear()
    s.display('정리후 :')
    
