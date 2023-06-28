def solution(arr):
    for x in range(len(arr)):
        if (arr[x] >= 50) and (arr[x] % 2 == 0):
            arr[x] = int(arr[x] / 2)
        elif (arr[x] < 50) and (arr[x] % 2 == 1):
            arr[x] = arr[x] * 2
    return arr