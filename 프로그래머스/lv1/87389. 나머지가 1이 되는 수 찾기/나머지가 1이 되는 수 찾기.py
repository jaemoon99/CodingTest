def solution(n):
    answer = 1
    while 1:
        if n % answer == 1:
            return answer
        else:
            answer += 1