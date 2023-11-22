def solution(food):
    answer = ''
    
    for i, j in enumerate(food[1:]):
        answer += str(i + 1) * (j // 2)
        
    return answer + "0" + answer[::-1]