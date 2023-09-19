def solution(arr, queries):
    for x in queries:
        for y in range(x[0], x[1]+1):
            arr[y] += 1
    return arr