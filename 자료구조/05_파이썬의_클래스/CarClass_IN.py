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
    
# Car를 상속한 SuperCar 클래스 만들기
class SuperCar(Car) :
    def __init__(self, color, speed=0,bTurbo =True) :
        super().__init__(color,speed)
        self.bTurbo=bTurbo
    
    def speedUp(self) :
        if self.bTurbo :
            self.speed += 30
        else :
            super().speedUp()

    def __str__(self) :
        if self.bTurbo :
            return "color = %s, speed = %d , 터보모드" % (self.color , self.speed)
        else:
            return "color = %s, speed = %d , 일반모드" % (self.color , self.speed)


#객체 생성
sCar= SuperCar("blackpink", 0 , True)
print("sCar :", sCar)
sCar.speedUp()
sCar.speedUp()
print("sCar :", sCar)
