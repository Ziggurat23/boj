# 순환 구조로 구현한 factorial 함수

def factorial(n) :
    if n==1 :
        return 1
    else :
        return (n*factorial(n-1))


n=6

print("순환 구현 :",n,"! =", factorial(n))


# 반복 구조로 구현한 factorial 함수

def factorial_iter(n) :
    result = 1
    for k in range( n , 0, -1) :
        result= result * k
    return result

n=6

print("반복 구현 :",n,"! =", factorial_iter(n))