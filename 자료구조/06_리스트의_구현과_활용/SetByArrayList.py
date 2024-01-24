
from ArrayListClassBasic import ArrayList

# Set.

class Set:
    def __init__(self,capacity=10):
        self.list = ArrayList(capacity)
    
    def size( self ):
        return self.list.size()
    
    def contains(self, elem):           # elem이 원소인지 검사
        if self.list.find(elem) >= 0:   # 원소가 이미 있으면
            return True
        else : return False

    def insert(self, elem) :
        if not self.contains(elem):
            self.list.insert(self.size(), elem)
    
    def delete(self,elem):
        id = self.list.find(elem)
        if id >= 0 :
            self.list.delete(id)

    def display(self, msg):
        self.list.display(msg)

    def clone(self):
        newSet = Set()
        for i in range(self.size()):
            newSet.insert(self.list.getEntry(i))
        return newSet

    def union(self, setB):
        newSet = self.clone()
        for i in range(setB.size()):
            newSet.insert(setB.list.getEntry(i))
        return newSet

    def intersect(self, setB):
        newSet = Set()
        for i in range(self.size()):
            e1 = self.list.getEntry(i)
            for j in range(setB.size()):
                e2 = setB.list.getEntry(j)
                if e1 == e2 :
                    newSet.insert(e1)
        return newSet

    def difference(self, setB):
        newSet = self.clone()
        for i in range(setB.size()):
            newSet.delete(setB.list.getEntry(i))
        return newSet


# 리스트로 구현한 집합
setA= Set()
setA.insert('휴대폰')
setA.insert('지갑')
setA.insert('손수건')
setA.display('Set A:')

setB= Set()
setB.insert('빗')
setB.insert('자료구조')
setB.insert('야구공')
setB.insert('지갑')
setB.display('Set B:')


setA.delete('손수건')
setA.delete('발수건')
setA.display('Set A:')
setB.insert('빗')
setB.display('Set B:')

s0 = setA.union(setB)
s1 = setA.intersect(setB)
s2 = setA.difference(setB)


s0.display('A U B :')
s1.display('A ^ B :')
s2.display('A - B :')