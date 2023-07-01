def solution(arr, idx):
    return -1 if len([x for x in range(len(arr)) if arr[x] == 1 and x >= idx]) == 0 else min([x for x in range(len(arr)) if arr[x] == 1 and x >= idx])