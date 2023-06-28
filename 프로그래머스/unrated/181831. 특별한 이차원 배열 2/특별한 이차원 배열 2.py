def solution(arr):
    answer = 0
    for x in range(len(arr)):
        for y in range(len(arr)):
            if arr[x][y] != arr[y][x]:
                answer += 1
    return 1 if answer == 0 else 0