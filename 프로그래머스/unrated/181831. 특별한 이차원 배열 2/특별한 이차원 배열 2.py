def solution(arr):
    answer = 0
    for x in range(len(arr)):
        for y in range(len(arr)):
            if arr[x][y] != arr[y][x]:
                return 0
    return 1