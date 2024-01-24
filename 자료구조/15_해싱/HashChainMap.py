class Entry:
    def __init__(self, key, value):
        self.key = key
        self.value = value

    def __str__(self):
        return str("%s:%s" % (self.key, self.value))

class Node:
    def __init__(self,elem,link):
        self.data= elem
        self.link= link

class HashChainMap:
    def __init__(self, M):
        self.table = [None]*M
        self.M = M

    def hashFn(self, key):
        sum=0
        for c in key:
            sum = sum + ord(c)
        return sum % self.M

    def insert(self, key, value):
        idx = self.hashFn(key)
        self.table[idx] = Node(Entry(key,value), self.table[idx])

    def search(self, key):
        idx = self.hashFn(key)
        node = self.table[idx]
        while node is not None:
            if node.data.key == key : return node.data
            node = node.link
        return None

    def delete(self, key):
        idx = self.hashFn(key)
        node = self.table[idx]
        before = None
        while node is not None:         #None이 아닐때까지
            if node.data.key == key :          #삭제할 레코드 찾음
                if before == None :     #첫번째 항목 삭제
                    self.table[idx] = node.link
                else :                  #두번째 이후 항목삭제
                    before.link=node.link
                return
            before=node
            node=node.link
       

    def display(self, msg):
        print(msg)
        for idx in range(len(self.table)):
            node=self.table[idx]
            if node is not None :
                print("[%2d] -> "%idx,end='')
                while node is not None:
                    print(node.data,end=' -> ')
                    node= node.link
                print( )


#=================================================
if __name__ == "__main__":
    map = HashChainMap(13)
    map.insert('data', '자료')
    map.insert('structure', '구조')
    map.insert('sequential search', '선형 탐색')
    map.insert('game', '게임')
    map.insert('binary search', '이진 탐색')
    map.display("나의 단어장: ")

    print("탐색:game --> ", map.search('game'))
    print("탐색:over --> ", map.search('over'))
    print("탐색:data --> ", map.search('data'))

    map.delete('game')
    print("삭제:game ")
    map.display("나의 단어장: ")

