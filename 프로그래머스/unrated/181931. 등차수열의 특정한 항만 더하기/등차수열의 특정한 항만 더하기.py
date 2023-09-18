def solution(a, d, included):
    answer = 0
    for x in range(len(included)):
        if included[x] == True:
            answer += (a+d*x)
    return answer