from selection_sort import selection_sort

def interpolation_search(A, key, low, high, count = [0]): # count를 기본값으로 가진 리스트로 추가
    count[0] += 1  # 탐색이 수행될 때마다 카운터 증가
    if low <= high:
        middle = int(low + (high-low) * ((key-A[low]) / (A[high]-A[low])))
        if key == A[middle]:
            return middle, count[0]  # 탐색 성공 및 카운터 값 반환
        elif key < A[middle]:
            return interpolation_search(A, key, low, middle - 1, count)  # 왼쪽 부분리스트 탐색
        else:
            return interpolation_search(A, key, middle + 1, high, count)  # 오른쪽 부분리스트 탐색
    return -1, count[0]





list = [5,3,8,4,9,1,6,2,7,44,66,894,1023,2084,203,124790,58433]
selection_sort(list)

#찾을 값 (key)
n = 894

index, count = interpolation_search(list, n, 0, len(list)-1)
print(f'정렬된 리스트에서 {n}의 위치 : {index}, 탐색 횟수 : {count}')
#len는 실제 끝 인덱스의 +1이니 -1를 꼭 해준다.