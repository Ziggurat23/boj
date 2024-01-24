

from stackClass import Stack


def evalPostfix( expr) :
    s= Stack()
    for token in expr:
        if token in expr :
            if token in "+-*/" :
                val2 = s.pop()
                val1 = s.pop()
                if (token=='+'): s.push(val1+val2)
                elif (token=='-'): s.push(val1-val2)
                elif (token=='*'): s.push(val1*val2)
                elif (token=='/'): s.push(val1/val2)
            else :
                s.push(float(token))
    return s.pop()


if __name__ == "__main__":
    print('스택의 응용2 : 후위표기식 계산 \n')

    str1='8 2 / 3 - 3 2 * +'
    expr1=str1.split()
    str2='1 2 / 4 * 1 4 / *'
    expr2=str2.split()
    str3='8 2 / 3 - 3 2 * +'
    expr3=str3.split()

    print(expr1, ' --> ',evalPostfix(expr1))
    print(expr2, ' --> ',evalPostfix(expr2))
    print(expr3, ' --> ',evalPostfix(expr3))