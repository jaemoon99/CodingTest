def solution(arr):
    if len(arr) > len(arr[0]):
        for x in range(len(arr)):
            arr[x] += [0]*(len(arr) - len(arr[x]))
    elif len(arr) < len(arr[0]):
        for x in range(len(arr[0]) - len(arr)):
            arr.append([0]*len(arr[0]))
    return arr