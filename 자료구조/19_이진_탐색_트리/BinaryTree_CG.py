from QueueCircular import CircularQueue

class TNode:
    def __init__(self, elem, left, right):
        self.data = elem
        self.left = left
        self.right = right

    def isLeaf(self):
        return self.left is None and self.right is None

def preorder(n):
    if n is not None:
        print(n.data, end=' ')
        preorder(n.left)
        preorder(n.right)

    def inorder(n):
        if n is not None:
            inorder(n.left)
            print(n.data, end=' ')
            inorder(n.right)

def postorder(n):
    if n is not None:
        postorder(n.left)
        postorder(n.right)
        print(n.data, end=' ')

def levelorder(root):
    queue = CircularQueue()
    queue.enqueue(root)
    while not queue.isEmpty():
        n = queue.dequeue()
        if n is not None:
            print(n.data, end=' ')
            queue.enqueue(n.left)
            queue.enqueue(n.right)


# 일반 함수들
def count_node(n):
    if n is None:
        return 0
    else:
        return 1 + count_node(n.left) + count_node(n.right)

def count_leaf(n):  # 트리의 단말 노드 수 계산 함수
    if n is None:  # 공백 트리이면 --> 0 반환
        return 0
    elif n.isLeaf():  # 단말 노드이면 --> 1 반환
        return 1
    else:  # 순환 호출
        return count_leaf(n.left) + count_leaf(n.right)

def calc_height(n):  # 트리의 높이 계산 함수
    if n is None:  # 공백 트리이면 --> 높이 0 반환
        return 0
    hLeft = calc_height(n.left)  # 왼쪽 서브트리의 높이 계산
    hRight = calc_height(n.right)  # 오른쪽 서브트리의 높이 계산
    if (hLeft > hRight):
        return hLeft + 1
    else:
        return hRight +1

# Example Usage


#배열 표기법
tree1=[None,'A','B','C','D','E','F']
tree2=[None,'A','B',None,'C',None,None,None,'D']


#링크표기법

d = TNode('D', None, None)
e = TNode('E', None, None)
b = TNode('B', d, e)
f = TNode('F', None, None)
c = TNode('C', f, None)  # 'c'를 대문자 'C'로 수정하였습니다.
tree1 = TNode('A', b, c)


print(" 노드의 개수 = %d개" % count_node(tree1))
print(" 단말의 개수 = %d개" % count_leaf(tree1))
print(" 트리의 높이 = %d" % calc_height(tree1))
print()

d = TNode('D', None, None)
c = TNode('C', d, None)
b = TNode('B', c, None)
tree2 = TNode('A', b, None)

print(" 노드의 개수 = %d개" % count_node(tree2))
print(" 단말의 개수 = %d개" % count_leaf(tree2))
print(" 트리의 높이 = %d" % calc_height(tree2))
