T = int(input())
for test_case in range(1, T + 1):
    time_list = list(map(int, input().split()))
    hour = time_list[0] + time_list[2]
    minute = time_list[1] + time_list[3]
    if minute >= 60:
        hour += 1
        minute -= 60
    if hour >= 13:
        hour -= 12
    print(f'#{test_case} {hour} {minute}')