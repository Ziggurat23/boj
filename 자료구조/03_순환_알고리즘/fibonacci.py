# 피보나치 순환

def fib(n) :
    # print( ' fib(%d)' % n)
    if n ==0 :return 0
    elif n==1 : return 1
    else :
        return fib(n - 1) + fib(n - 2)
    





# 피보나치 반복

def fib_iter(n) :
    if (n < 2) : return n

    last = 0
    current = 1
    for i in range (2, n+1) :
        tmp = current
        current += last
        last = tmp
    return current

n=6
print("피보나치 반복(",n,") =",fib_iter(n))
print("피보나치 순환(",n,") =",fib(n))

import time

for i in range(1,33):
    t1 = time.time()
    fib_iter(i)
    t2 = time.time()
    fib(i)
    t3 = time.time()
    print("n=",i,"\t반복:",t2-t1,"순환:",t3-t2)