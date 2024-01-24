#속도 측정 알고리즘

def find_max (A):
        max = A[0]
        for item in A :
            if item > max :
                max = item
        return max

#실행시간 측정 프로그램
import time
#time 모듈 불러오기

array = [ 1 , 4 , 7 , 8 , 2, 55 , 44 ,289, 891]

start= time.time()
#현재 시각을 저장
max = find_max(array)
# 실행시간을 측정하려는 코드
end = time.time()
# 현재 시각을 저장

print("최댓값 = " , max )
print("실행시간 = ", end-start) #실행시간 측정 (종료시간 - 시작시간)


#============================

import random 
# random 모듈 불러오기

array= [random.randint(0, 10000) for i in range(10000)]
#randint 랜덤한 숫자 발생, 10000개의 숫자를 랜덤으로 발생하게 해서 리스트에 10000개의 숫자를 넣음

#
start= time.time()
for n in range(10000) :
    max = find_max(array)
end = time.time()

print("최댓값 = ", max) 
print("실행시간 = ", end-start) #실행시간 측정 (종료시간 - 시작시간)