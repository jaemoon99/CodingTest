def solution(box, n):
    answer = 1
    for x in range(len(box)):
        answer *= box[x]//n
    return answer