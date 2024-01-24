

# SequentialMap.
class Entry:
    def __init__(self, key, value):
        self.key = key
        self.value = value

    def __str__(self):
        return str("\t%s:%s" % (self.key, self.value))

class BinaryMap:
    def __init__(self):
        self.table = []

    def size(self):
        return len(self.table)

    def insert(self, key, value):  # 삽입 연산
        pos = 0
        while pos < self.size():  # 삽입할 위치를 찾아야 함
            if self.table[pos].key >= key:
                break
            pos += 1
        self.table.insert(pos, Entry(key, value))  # 엔트리 삽입


    def search(self, key):  # 이진 탐색
        pos = self.binary_search(self.table, key, 0, self.size()-1)
        if pos >= 0:  # 탐색 성공
            return self.table[pos]
        else:  # 탐색 실패
            return None
        

    def delete(self, key):  # 삭제를 원하는 가장 인덱스의 엔트리 찾기: 이진 탐색
        pos = self.binary_search(self.table, key, 0, self.size()-1)
        if pos >= 0:  # 엔트리가 있으면
            self.table.pop(pos)  # 리스트에서 삭제


    def display(self, msg):
        print(msg)
        for entry in self.table:
            print(entry)


    def binary_search(self, A, key, low, high):
        if low <= high:
            middle = (low + high) // 2
            if key == A[middle].key:
                return middle
            elif key < A[middle].key:
                return self.binary_search(A, key, low, middle - 1)
            else:
                return self.binary_search(A, key, middle + 1, high)
        return -1
    


#=================================================
if __name__ == "__main__":
    map = BinaryMap()
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

#=================================
# 파이썬 내장 딕셔너리

print("\n\n파이썬 딕션너리는 이름을 나의 단어장")
d = {}
d['data'] = '자료'
d['structure'] = '구조'
d['sequential search'] = '선형 탐색'
d['game'] = '게임'
d['binary search'] = '이진 탐색'
print("나의 단어장:")
print(d)
if d.get('game'): print("탐색:game --> ", d['game'])
if d.get('over'): print("탐색:over --> ", d['over'])
if d.get('data'): print("탐색:data --> ", d['data'])
d.pop('game')
print('삭제:game')
print('나의 단어장: ')
print(d)
