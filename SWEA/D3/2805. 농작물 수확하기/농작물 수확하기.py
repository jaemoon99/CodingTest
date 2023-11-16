T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    area = [list(input()) for _ in range(N)]
    num_list = [x for x in range(1, N + 1, 2)]
    num_list = num_list + num_list[:-1][::-1]
    answer = 0

    for x in range(N):
        sub = abs(x - (N // 2))
        sub_list = area[x][sub:sub + num_list[x]]
        answer += sum([int(y) for y in sub_list])

    print(f'#{test_case} {answer}')
