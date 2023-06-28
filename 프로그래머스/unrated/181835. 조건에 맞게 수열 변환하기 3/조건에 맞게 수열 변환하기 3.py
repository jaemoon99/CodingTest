def solution(arr, k):
    if k % 2 == 0:
        for x in range(len(arr)):
            arr[x] = arr[x] + k
    else:
        for x in range(len(arr)):
            arr[x] = arr[x] * k
    return arr