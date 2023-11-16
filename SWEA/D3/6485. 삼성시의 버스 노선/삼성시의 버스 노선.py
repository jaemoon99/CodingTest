T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    route = [list(map(int, input().split())) for _ in range(N)]
    P = int(input())
    bus_stop = [int(input()) for _ in range(P)]
    answer = []

    for x in bus_stop:
        count = 0
        for y in route:
            if y[1] >= x >= y[0]:
                count += 1
        answer.append(count)

    print(f'#{test_case}{"".join([" " + str(x) for x in answer])}')