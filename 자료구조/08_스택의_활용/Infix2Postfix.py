from stackClass import Stack
from evalPostfix import evalPostfix

def precedence (op):
    if   (op=='(' or op==')') : return 0;
    elif (op=='+' or op=='-') : return 1;
    elif (op=='*' or op=='/') : return 2;
    else : return -1


def Infix2Postfix( expr ):
    s = Stack()
    output=[]
    for term in expr:
        if term in '(' :
            s.push('(')
        
        elif term in ')' :
            while not s.isEmpty():
                op = s.pop()
                if op=='(' :
                    break;
                else :
                    output.append(op)
        elif term in "+-*/" :
            while not s.isEmpty():
                op = s.peek()
                if ( precedence(term) <= precedence(op)):
                    output.append(op)
                    s.pop()
                else: break
            s.push(term)
        else :
            output.append(term)
    while not s.isEmpty():
        output.append(s.pop())

    return output



if __name__ == "__main__":
    print('스택의 응용3 : 중위표기식 후위표기 변환 \n')

    str1='8 / 2 - 3 + ( 3 * 2 )'
    infix1=str1.split()
    str2='1 / 2 * 4 * ( 1 / 4 )'
    infix2=str2.split()
    postfix1 = Infix2Postfix(infix1)
    postfix2 = Infix2Postfix(infix2)
    
    result1= evalPostfix(postfix1)
    result2= evalPostfix(postfix2)

    print ( ' 중위표기 :' , infix1)
    print ( ' 후위표기 :' , postfix1)
    print ( ' 계산결과 :' , result1, end='\n\n')

    print ( ' 중위표기 :' , infix2)
    print ( ' 후위표기 :' , postfix2)
    print ( ' 계산결과 :' , result2, end='\n\n')
