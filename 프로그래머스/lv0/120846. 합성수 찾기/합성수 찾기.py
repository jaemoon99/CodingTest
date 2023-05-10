def solution(n):
    answer = 0
    for x in range (1, n+1):
        count = 0
        for y in range(1, n+1):
            if x % y == 0:
                count += 1
        if count >= 3:
            answer += 1
    return answer