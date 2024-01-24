def find_max( A ):
    max = A[0]
    for item in A :
        if item > max :
            max = item
    return max


# 테스트 코드
array = [ 20 , 34 , 12 , 94 ,84 ,39 ,64, 55, 24]
print("A = ", array)
print("max(A) = ", find_max(array) )