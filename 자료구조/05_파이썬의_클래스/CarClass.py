

# 클래스 정의

class Car :
    # 생성자 함수 : 데이터 멤버 정의 및 초기화
    def __init__(self, color, speed=0) :
        self.color = color
        self.speed = speed

    def display(self) :
        print(self.color, ":", self.speed)

    def speedUp(self) :
        self.speed += 10

    def speedDown(self) :
        self.speed -= 10

#객체 생성
black = Car('black',0)
red = Car('red',120)
yellow = Car('black',30)
blue = Car('blue')
green = Car('green')

black.display()
red.display()
yellow.display()
blue.display()
green.display()

green.speedUp()
green.speedUp()
green.speedUp()
green.display()


red.speedDown()
red.speedDown()
red.display()