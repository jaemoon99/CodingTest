def solution(arr):
    min_num = sorted(arr, reverse = 1)[-1]
    if len(arr) == 1:
        return [-1]
    else:
        arr.remove(min_num)
        return arr