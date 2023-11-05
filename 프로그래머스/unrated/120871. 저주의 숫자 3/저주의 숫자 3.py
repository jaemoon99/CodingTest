def solution(n):
    answer = 1
    count = 0
    while 1:
        if answer % 3 == 0 or "3" in str(answer):
            pass
        else:
            count += 1
        answer += 1
        
        if count == n:
            
            return answer - 1