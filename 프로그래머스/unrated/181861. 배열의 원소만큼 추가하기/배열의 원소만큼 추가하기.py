def solution(arr):
    answer = []
    for x in arr:
        answer += [x] * x
    return answer