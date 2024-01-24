
def hanoi_tower(n,fr,tmp,to):
    global step
    if (n == 1) :
        step +=1
        print("원판 1: %s --> %s" % (fr,to))

    else :
        hanoi_tower(n-1,fr,to,tmp)
        step +=1
        print("원판 %d: %s --> %s" % (n,fr,to))
        hanoi_tower(n-1,tmp,fr,to)

step = 0
hanoi_tower(10 ,'A','B','C')
print(step)