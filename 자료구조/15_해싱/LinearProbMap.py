class Entry:
    def __init__(self, key, value):
        self.key = key
        self.value = value

    def __str__(self):
        return str("%s:%s" % (self.key, self.value))

class LinearProbMap:
    def __init__(self, M):
        self.table = [None]*M
        self.M = M

    def hashFn(self, key):
        return key % self.M

    def insert(self, key, value):
        id = self.hashFn(key)
        count = self.M
        while count > 0 and (self.table[id] is not None and self.table[id] != -1):
            id = (id + 1 + self.M) % self.M
            count -= 1

        if count > 0:
            self.table[id] = Entry(key, value)
        return

    def search(self, key):
        id = self.hashFn(key)
        count = self.M
        while count > 0:
            if self.table[id] == None: return None
            if self.table[id] != -1 and self.table[id].key == key:
                return self.table[id]
            id = (id + 1 + self.M) % self.M
            count -= 1
        return None
    
    def delete(self, key):
        id = self.hashFn(key)
        count = self.M
        while count > 0:
            if self.table[id] == None: return None
            if self.table[id] != -1 and self.table[id].key == key:
                self.table[id] = -1
                return
            id = (id + 1 + self.M) % self.M
            count -= 1

    def display(self, msg):
        print(msg, end='')
        for e in self.table:
            if e == None: print(" x ", end='')
            elif e == -1: print(" o ", end='')
            else: print("%3d" % e.key, end='')
        print( )

#===========================================
map = LinearProbMap(13)
# 45, 27, 88, 9, 71, 60, 46, 38, 24
map.insert(45, "사십오");
map.display("테이블: ")
map.insert(27, "이십칠");
map.display("테이블: ")
map.insert(88, "팔십팔");
map.display("테이블: ")
map.insert(9, "구");
map.display("테이블: ")
map.insert(71, "칠십일");
map.display("테이블: ")
map.insert(60, "육십");
map.display("테이블: ")
map.insert(46, "사십육");
map.display("테이블: ")
map.insert(38, "삼십팔");
map.display("테이블: ")
map.insert(24, "이십사");
map.display("테이블: ")

print("탐색:46 --> ", map.search(46))
print("탐색:39 --> ", map.search(39))

print(" 삭제:27")
map.delete(27);
map.display("테이블: ")
print(" 삭제:46")
map.delete(46);
map.display("테이블: ")
