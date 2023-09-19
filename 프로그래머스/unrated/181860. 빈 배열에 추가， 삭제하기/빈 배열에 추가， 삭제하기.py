def solution(arr, flag):
    answer = []
    for x in range(len(flag)):
        if flag[x] == True:
            for y in range(arr[x] * 2):
                answer.append(arr[x])
        else:
            answer = answer[0:len(answer)-arr[x]]
    return answer