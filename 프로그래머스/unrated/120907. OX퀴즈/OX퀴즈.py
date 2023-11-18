def check(string):
    a, b, c, d, e = string.split()
    res = ""
    
    if b == "+":
        if int(e) == int(a) + int(c):
            res = "O"
        else:
            res = "X"
    
    elif b == "-":
        if int(e) == int(a) - int(c):
            res = "O"
        else:
            res = "X"
    
    return res
    

def solution(quiz):
    answer = []
    
    for x in quiz:
        answer.append(check(x))
    return answer