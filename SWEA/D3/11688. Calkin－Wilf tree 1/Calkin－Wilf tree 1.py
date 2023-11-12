T = int(input())
for test_case in range(1, T + 1):
    root = [1, 1]
    command = list(input())
    for x in command:
        if x == "L":
            root[1] = sum(root)
        else:
            root[0] = sum(root)
    print(f'#{test_case} {root[0]} {root[1]}')