def solution(arr, queries):
    for x in queries:
        arr[x[0]], arr[x[1]] = arr[x[1]], arr[x[0]]
    return arr