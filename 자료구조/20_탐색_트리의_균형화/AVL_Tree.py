class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
        self.height = 1

class AVLTree:

    def __init__(self):
        self.root = None
        
    def getHeight(self, node):      # 균형인수
        if not node:
            return 0
        return node.height

    def getBalance(self, node):
        if not node:
            return 0
        return self.getHeight(node.left) - self.getHeight(node.right)

    def rotateRR(self, A):
        B = A.right
        A.right = B.left
        B.left = A
        A.height = 1 + max(self.getHeight(A.left), self.getHeight(A.right))
        B.height = 1 + max(self.getHeight(B.left), self.getHeight(B.right))
        return B

    def rotateLL(self, A):
        B = A.left
        A.left = B.right
        B.right = A
        A.height = 1 + max(self.getHeight(A.left), self.getHeight(A.right))
        B.height = 1 + max(self.getHeight(B.left), self.getHeight(B.right))
        return B

    def insert(self, root, key):
        if not root:
            return Node(key)
        if key < root.key:
            root.left = self.insert(root.left, key)
        else:
            root.right = self.insert(root.right, key)

        root.height = 1 + max(self.getHeight(root.left), self.getHeight(root.right))

        balance = self.getBalance(root)

        # LL 회전
        if balance > 1 and key < root.left.key:
            return self.rotateLL(root)
        # RR 회전
        if balance < -1 and key > root.right.key:
            return self.rotateRR(root)
        # LR 회전
        if balance > 1 and key > root.left.key:
            root.left = self.rotateRR(root.left)
            return self.rotateLL(root)
        # RL 회전
        if balance < -1 and key < root.right.key:
            root.right = self.rotateLL(root.right)
            return self.rotateRR(root)

        return root
    

    def display(self, root, level=0, prefix="Root: "):
        """Recursive function to display tree."""
        if root is not None:
            print(" " * (level * 4) + prefix + str(root.key))
            if root.left is not None or root.right is not None:
                self.display(root.left, level + 1, "  L--- ")
                self.display(root.right, level + 1,"  R--- ")

# ... 기존의 코드 ...

# 예제
tree = AVLTree()
root = None
root = tree.insert(root, 10)
root = tree.insert(root, 20)
root = tree.insert(root, 30)
root = tree.insert(root, 40)
root = tree.insert(root, 50)

tree.display(root)

