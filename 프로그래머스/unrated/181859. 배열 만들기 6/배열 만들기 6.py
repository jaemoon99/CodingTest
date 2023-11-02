def solution(arr):
    answer = []
    for i, x in enumerate(arr):
        if answer == []:
            answer.append(arr[i])
        else:
            if answer[-1] == arr[i]:
                answer.pop()
            else:
                answer.append(arr[i])
    if answer == []:
        return [-1]
    return answer