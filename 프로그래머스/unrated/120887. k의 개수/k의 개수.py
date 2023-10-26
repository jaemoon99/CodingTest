def solution(i, j, k):
    answer = 0
    for x in range(i, j+1):
        for y in str(x):
            if int(y) == k:
                answer += 1
    return answer