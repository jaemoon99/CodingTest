def solution(order):
    answer = 0
    for x in order:
        if 'cafelatte' in x:
            answer += 5000
        else:
            answer += 4500
    return answer