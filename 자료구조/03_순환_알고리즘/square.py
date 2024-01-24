# 반복 구조의 거듭 알고리즘

def slow_power(x, n) :
    result = 1.0
    for i in range(n) :
        result = result * x
    return result

x=2
n=10
print(x,"의",n,"승 =", slow_power(x,n))

x=3
n=23
print(x,"의",n,"승 =", slow_power(x,n))

# 순환 구조의 거듭제곱 알고리즘

def power(x , n) :
    if n == 0 : return 1.0
    elif (n % 2) == 0 :
        return power (x*x , n//2)
    else :
        return x*power (x*x, (n-1)//2)

x=2
n=10
print(x,"의",n,"승 =", power(x,n))

x=3
n=23
print(x,"의",n,"승 =", power(x,n))


#====

import time

x=2
n=500
print("순환구조 : ",x,"의",n,"승 =", power(x,n))
print("반복구조 : ",x,"의",n,"승 =", slow_power(x,n))

t1 = time.time()
for i in range(100000) :
        power(x,n)
t2 = time.time()
for i in range(100000) :
        slow_power(x,n)
t3 = time.time()

print("순환구조..",t2-t1)
print("반복구조..",t3-t2)
