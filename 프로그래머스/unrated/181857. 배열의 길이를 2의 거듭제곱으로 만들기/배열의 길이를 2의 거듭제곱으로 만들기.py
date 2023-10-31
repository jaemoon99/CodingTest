def solution(arr):
    if (len(arr) & (len(arr) - 1)) == 0:
        return arr
    else:
        while 1:
            if (len(arr) & (len(arr) - 1)) == 0:
                return arr
            arr.append(0)