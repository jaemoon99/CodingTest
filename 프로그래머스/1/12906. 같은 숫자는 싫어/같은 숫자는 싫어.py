def solution(arr):
    answer = []
    for x in arr:
        if answer == [] or x is not answer[-1]:
            answer.append(x)
    return answer