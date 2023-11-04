def solution(picture, k):
    answer = []
    for i, x in enumerate(picture):
        temp = ''
        for y in x:
            temp += k * y
        for z in range(k):
            answer.append(temp)
    return answer