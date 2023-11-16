T = int(input())
for test_case in range(1, T + 1):
    N, M, K = map(int, input().split())
    stop = sorted(list(map(int, input().split())))
    result = "Possible"

    for x in range(N):
        count = (stop[x] // M) * K - x
        if 0 >= count:
            result = "Impossible"
            break

    print(f'#{test_case} {result}')