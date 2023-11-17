T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    on_off = list(map(int, input().split()))
    answer = []

    for _ in on_off:
        day = 0
        count = 0
        index = 0
        on_off = on_off[1:] + [on_off[0]]
        while count != n:

            if on_off[index % 7] == 1:
                index += 1
                count += 1
                day += 1

            elif count == 0 and day == 0:
                index += 1

            else:
                index += 1
                day += 1
        answer.append(day)

    print(f'#{test_case} {min(answer)}')