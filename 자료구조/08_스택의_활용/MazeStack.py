from stackClass import Stack

map = [
    ("1 1 1 1 1 1").split(),
    ("e 0 0 0 0 1").split(),
    ("1 0 1 0 1 1").split(),
    ("1 1 1 0 0 1").split(),
    ("x 0 0 0 1 1").split(),
    ("1 1 1 1 1 1").split()
]

MAZE_SIZE = 6

def isValidPos(x,y) :
    if x < 0 or y < 0 or x >= MAZE_SIZE or y >= MAZE_SIZE :
        return False
    else :

        return map[y][x] == "0" or map[y][x] == 'x'

def DFS() :
    stack = Stack()
    stack.push((0,1))
    print('DFS: ')

    while not stack.isEmpty(): #공백이 아닐동안
        here = stack.pop()     #후단에서 항목을 꺼냄(pop)
        print(here, end='->')
        #here[0]이 x, here[1]이 y . 튜플 (x,y)
        (x,y) = here        
        if (map[y][x]== 'x'):    #출구면 성공
            return True
        else :
            map[y][x] = '.' #현재 위치 지나왔다고 '.' 표시
            #4방향 검사 , 검사해서 갈 수 있으면 덱 후단에 삽입
            if isValidPos(x - 1 , y): stack.push((x-1,y))
            if isValidPos(x + 1 , y): stack.push((x+1,y))
            if isValidPos(x  , y - 1): stack.push((x,y-1))
            if isValidPos(x  , y + 1): stack.push((x,y+1))
    return False

result=DFS()

if result : print(' --> 미로탐색 성공')
else : print(' --> 미로탐색 실패 ')