# 자료 구조 1회차 : BagFn.py

#자료구조 Bag의 ADT를 함수로 구현

def contains(Bag, e) :
    return e in Bag

def insert(bag, e) :
    bag.append(e)

def remove(bag, e) :
        bag.remove(e)
    
def count(bag) :
     return len(bag)

def numOf(bag, e) :
    count=0
    for i in range(len(bag)):
         if bag[i] == e :
              count = count + 1
    return count
            
myBag= [ ]

insert( myBag, '휴대폰')
insert( myBag, '지갑')
insert( myBag, '손수건')
insert( myBag, '빗')
insert( myBag, '자료구조')
insert( myBag, '야구공')



print('내 가방속의 물건 : ', myBag)


insert( myBag, '칫솔세트')
remove( myBag, '야구공')

print('내 가방속의 물건 : ', myBag)

print('빗의 개수 : ', numOf(myBag,'빗'))