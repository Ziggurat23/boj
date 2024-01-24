def sqareAlgorithmA( x ) :
    sum = x * x
    return sum

def sqareAlgorithmB( x ) :
    sum = 0
    for i in range (x) :
        sum += x
    return sum

def sqareAlgorithmC( x ) :
    sum = 0
    for i in range (x) :
        for i in range (x) :
                sum+= 1
    return sum

#================================
import time

print("알고리즘 A : 9 * 9 = " , sqareAlgorithmA(9))
print("알고리즘 B : 9 * 9 = " , sqareAlgorithmB(9))
print("알고리즘 C : 9 * 9 = " , sqareAlgorithmC(9))

n= 10000 # 입력값

#A 알고리즘
t0=time.time()
result = sqareAlgorithmA(n)
t1= time.time()
print(" 알고리즘 A의 실행시간 : ", t1-t0)

#B 알고리즘
t0=time.time()
result = sqareAlgorithmB(n)
t1= time.time()
print(" 알고리즘 B의 실행시간 : ", t1-t0)

#C 알고리즘
t0=time.time()
result = sqareAlgorithmC(n)
t1= time.time()
print(" 알고리즘 C의 실행시간 : ", t1-t0)


# C가 가장 비효율적
