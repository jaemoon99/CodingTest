T = int(input())
for test_case in range(1, T + 1):
    count = int(input())
    distance = 0
    acceleration = 0
    for _ in range(count):
        command = list(map(int, input().split()))
        if command[0] == 1:
            acceleration += command[1]
        elif command[0] == 2:
            if acceleration > command[1]:
                acceleration -= command[1]
            else:
                acceleration = 0
        distance += acceleration
    print(f'#{test_case} {distance}')