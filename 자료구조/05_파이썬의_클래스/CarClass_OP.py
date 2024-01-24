# ==연산자 중복 3 + 4, 3.0+4.5
# str연산자 중복

#클래스 정의
class Car :
    def __init__(self, color, speed=0) :
        self.color = color
        self.speed = speed

    def display(self) :
        print(self.color, ":", self.speed)

    def speedUp(self) :
        self.speed += 10

    def speedDown(self) :
        self.speed -= 10

    def isEqual(self, carB) : #a.isEqual(b)로 비교
        if self.color == carB.color :
            return True
        else :
            return False
    
    def __eq__(self, carB) : #a == b로 비교
        if self.color == carB.color :
            return True
        else :
            return False
        
    def __str__(self) :
        return "color = %s, speed = %d" % (self.color , self.speed)


#객체 생성
black = Car('black',0)
red = Car('red',120)


black.display()
red.display()



red2 = Car('red')

print("black.isEqual(red2) :", black.isEqual(red2))
print("black==red2 :", black == red2)
print("red.isEqual(red2) :", red.isEqual(red2))
print("red==red2 :", red == red2)
 
print("black car info: ", black)   
