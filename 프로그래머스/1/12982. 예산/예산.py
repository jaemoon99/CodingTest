def solution(d, budget):
    answer = 0
    for x in sorted(d):
        budget -= x
        if 0 > budget:
            return answer
        elif 0 == budget:
            return answer + 1
        answer += 1
    return answer