def solution(a, b, n):
    answer = 0
    sub = 0
    
    while 1:
        
        if n < a:
            sub += n
            break
        
        answer += (n // a) * b
        n = (n // a) * b + (n % a)
        
    return answer