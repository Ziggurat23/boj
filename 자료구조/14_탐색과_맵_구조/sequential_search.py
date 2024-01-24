
def sequential_search(A, key, low, high):
    for i in range(low, high+1):
        if A[i] == key: return i  # 리스트에 속하는 값의 인덱스 반환
    return -1  # 리스트에 속하지 않으면 -1 반환



list=[5,3,8,4,9,1,6,2,7]

print(sequential_search(list,2,0,8))