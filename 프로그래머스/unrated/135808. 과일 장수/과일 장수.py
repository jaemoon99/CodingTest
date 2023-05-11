def listsplit(score, n):
    list = []
    for x in range(0, len(score), n):
        list.append(score[x:x+n])
    return list

def solution(k, m, score):
    answer = 0
    chunk = listsplit(sorted(score, reverse=True), m)
    for x in chunk:
        if len(x) == m:
            answer += x[-1] * m
    return answer