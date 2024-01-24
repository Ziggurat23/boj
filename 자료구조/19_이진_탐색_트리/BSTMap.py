from BinaryTree_CG import count_node
from collections import deque
from BinaryTree_CG import TNode
from QueueCircular import CircularQueue
class BSTNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value  
        self.left = None
        self.right = None

    def isLeaf(self):
        return self.left is None and self.right is None




#키를 이용한 탐색
def search_bst(n, key):
    if n == None:
        return None
    elif key == n.key:
        return n
    elif key < n.key:
        return search_bst(n.left, key)
    else:
        return search_bst(n.right, key)

# 기본 이하탐색
# 고백 → 탐색 실패
# 같으면 → 탐색 성공
# 기본 작으면 → 왼쪽 서브 트리
# 기본 크면 → 오른쪽 서브 트리



def search_bst_iter(n, key):
    while n != None:
        if key == n.key:
            return n
        elif key < n.key:
            n = n.left
        else:
            n = n.right
    return None

# 기본 이하탐색(반복 구조)
# 고백이 아닌 때까지
# 같으면 → 탐색 성공
# 기본 작으면 → 왼쪽 서브 트리
# 기본 크면 → 오른쪽 서브 트리

def search_value_bst(n, value):
    if n == None:
        return None
    elif value == n.value:
        return n
    res = search_value_bst(n.left, value)
    if res is not None:
        return res
    return search_value_bst(n.right, value)

# 값을 이하탐색
# 루트값 검사
# 왼쪽 서브 트리로 값이 탐색
# 왼쪽에서 찾았으면 → 탐색 성공
# 오른쪽 서브 트리로 값이 탐색

def serach_min_bst(n):
    while n != None and n.left != None: 
        n = n.left
    return n

#왼쪽 서브 트리가 공백이 아닐때까지

def search_max_bst(n):
    while n != None and n.right != None:
        n = n.right
    return n

# 오른쪽 서브 트리가 공백이 아닐 때까지



def insert_bst(r, n):
    if n.key < r.key:
        if r.left is None:
            r.left = n
            return True
        else:
            return insert_bst(r.left, n)
    elif n.key > r.key:
        if r.right is None:
            r.right = n
            return True
        else:
            return insert_bst(r.right, n)
    else:
        return False
    
# 삽입 연산
# 왼쪽 서브 트리로 이동
# 왼쪽 서브 트리가 공백이면
# 왼쪽 자식으로 삽입
# 공백이 아닌 서브트리로
# 오른쪽 서브 트리로 이동
# 오른쪽 서브 트리가 공백이면
# 오른쪽 자식으로 삽입



#단말노드 삭제
def delete_bst_case1(parent, node, root):
    if parent is None:
        root = None      # 공백 트리가 된다
    else:
        if parent.left == node:
            parent.left = None   # 부모의 왼쪽 레퍼런스 None
        else:
            parent.right = None  # 부모의 오른쪽 레퍼런스 None
    return root
# 삭제할 단말 노드가 루트이면
# 공백 트리가 된다
# 삭제할 노드가 부모의 왼쪽 자식이면
# 부모의 왼쪽 링크를 None
# 오른쪽 자식이면
# 부모의 오른쪽 링크를 None


#자식이 하나인 노드의 삭제 알고리즘
def delete_bst_case2(parent, node, root):
    if node.left is not None:
        child = node.left      # 삭제할 노드가 왼쪽 자식만 가짐
    else:
        child = node.right     # 삭제할 노드가 오른쪽 자식만 가짐

    if node == root:
        root = child          # 예외처리: 노드가 루트이면
    else:
        if node is parent.left:
            parent.left = child   # 부모의 왼쪽 링크 변경
        else:
            parent.right = child  # 부모의 오른쪽 링크 변경

    return root

#두 개의 자식을 가진 노드 삭제 알고리즘
def delete_bst_case3(parent, node, root):
    succp = node
    succ = node.right
    while succ.left != None:
        succp = succ
        succ = succ.left

    if succp.left == succ:
        succp.left = succ.right
    else:
        succp.right = succ.right

    node.key = succ.key
    node.value = succ.value
    # node = succ; (commented out)

    return root

# 후계자 부모 노드
# 후계자 노드
# 후계자의 부모노드 탐색
# 후계자가 왼쪽 자식이면
# 후계자의 오른쪽 자식 연결
# 후계자가 오른쪽 자식이면
# 후계자의 오른쪽 자식 연결
# 후계자의 키값 복사
# 삭제된 노드에 복사
# 실제 삭제하는 것은 후계자 노드 (commented out)


#전체 삭제 알고리즘

def delete_bst(root, key):
    if root == None:
        return None
    parent = None
    node = root
    while node != None and node.key != key:
        parent = node
        if key < node.key:
            node = node.left
        else:
            node = node.right

    if node == None:
        return None


    if node.left == None and node.right == None:
        root = delete_bst_case1(parent, node, root)  # case 1
    elif node.left == None or node.right == None:
        root = delete_bst_case2(parent, node, root)  # case 2
    else:
        root = delete_bst_case3(parent, node, root)  # case 3

    return root

# 공백 트리
# 삭제할 노드의 부모 노드
# 삭제할 노드 탐색
# 삭제할 노드가 없음

#전위순회
def inorder(n):
    if n is not None:
        inorder(n.left)
        print(n.key, end=' ')
        inorder(n.right)


#레벨순회
from collections import deque

def levelorder(root):
    if not root:
        return

    queue = deque()
    queue.append(root)

    while queue:
        node = queue.popleft()
        print(node.key, end=' ')

        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)


def display_tree(node, level=0, prefix="Root: "):
    """Recursive function to display tree."""
    if node is not None:
        print(" " * (level * 4) + prefix + str(node.key))
        if node.left is not None or node.right is not None:  # if not a leaf node
            display_tree(node.left, level + 1, "  L--- ")
            display_tree(node.right, level + 1, "  R--- ")

#======================================================================
class BSTMap():
    def __init__(self):
        self.root = None

    def isEmpty(self): return self.root == None
    def clear(self): self.root = None
    def size(self): return count_node(self.root)

    def findMax(self): return search_max_bst(self.root)
    def findMin(self): return serach_min_bst(self.root)
    def search(self, key): return search_bst(self.root, key)
    #return search_bst_iter(self.root, key)
    def searchValue(self, key): return search_value_bst(self.root, key)

    def insert(self, key, value=None):
        n = BSTNode(key, value)
        if self.isEmpty():  
            self.root = n
        else:
            insert_bst(self.root, n)
    def delete(self, key):
        self.root = delete_bst(self.root, key)

    def display(self, msg = 'BTSMap: '):
        print(msg, end='')
        inorder(self.root)  # 이 부분은 중위 순회 대신 레벨 순회를 사용합니다.
        print()






#=============================================================
def testBinarySearchTree():
    print("======= 이진탐색트리 테스트 =======")

    map = BSTMap()
    data = [35, 18, 7, 26, 12, 3, 68, 22, 30, 99]

    # 삽입 연산 테스트
    print("입력된 데이터: ", data)
    for key in data:
        map.insert(key)

    print("트리 시각화:")
    display_tree(map.root)


    map.display("중위 순회 출력: ")

    # 탐색 연산 테스트
    if map.search(26) != None:
        print('탐색 26 ]: 성공')
    else:
        print('탐색 26 ]: 실패')
    if map.search(25) != None:
        print('탐색 25 ]: 성공')
    else:
        print('탐색 25 ]: 실패')

    # 삭제 연산 테스트
    map.delete(3); map.display("[ 3 삭제 ]: ")
    map.delete(68); map.display("[ 68 삭제 ]: ")
    map.delete(18); map.display("[ 18 삭제 ]: ")
    map.delete(35); map.display("[ 35 삭제 ]: ")

testBinarySearchTree()