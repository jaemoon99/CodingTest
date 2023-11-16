T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    days = [int(input()) for _ in range(N)]
    set_days = set()
    count = 0

    for x in range(1, len(days)):
        if days[x] not in set_days:
            sub = days[x] - 1
            for y in range(days[x], days[-1] + 1, sub):
                set_days.add(y)
            count += 1

    print(f'#{test_case} {count}')