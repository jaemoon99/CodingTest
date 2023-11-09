T = int(input())
for test_case in range(1, T + 1):
    n, k = map(int, input().split())
    data = [list(map(int, input().split())) for _ in range(n)]
    answer = 0

    for x in range(n):
        cnt = 0
        for y in range(n):
            if data[x][y] == 1:
                cnt += 1
            else:
                if cnt == k:
                    answer += 1
                cnt = 0
        if cnt == k:
            answer += 1

    for x in range(n):
        cnt = 0
        for y in range(n):
            if data[y][x] == 1:
                cnt += 1
            else:
                if cnt == k:
                    answer += 1
                cnt = 0
        if cnt == k:
            answer += 1


    print(f'#{test_case} {answer}')