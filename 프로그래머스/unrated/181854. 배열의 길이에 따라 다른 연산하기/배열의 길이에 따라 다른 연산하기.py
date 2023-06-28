def solution(arr, n):
    if len(arr) % 2 == 0:
        for x in range(len(arr)):
            if x % 2 == 1:
                arr[x] = arr[x] + n
    else:
        for x in range(len(arr)):
            if x % 2 == 0:
                arr[x] = arr[x] + n
    return arr