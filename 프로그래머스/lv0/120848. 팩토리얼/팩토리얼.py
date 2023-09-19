def factorial(n):
    if(n > 1):
        return n * factorial(n - 1)
    else:
        return 1
    
def solution(n):
    answer = 0
    while 1:
        if n >= factorial(answer):
            answer += 1
        else:
            return answer - 1