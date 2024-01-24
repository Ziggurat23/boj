
A = [1,2,3,4]

print("A(original) =",A)
A.append(7)
A.append(8)
A.append(9)
print("A(append) =",A)

A.pop()
A.pop()
print("A(pop*2) =",A)

A.insert(0,0)
A.insert(2,9)
print("A(insert*2) =",A)

A.pop(0)
A.pop(-1)
print("A(pop*2) =",A)
