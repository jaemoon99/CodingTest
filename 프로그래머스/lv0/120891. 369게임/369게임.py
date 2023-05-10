def solution(order):
    list = [3, 6, 9]
    answer = 0
    for x in str(order):
        if int(x) in list:
            answer+=1
    return answer