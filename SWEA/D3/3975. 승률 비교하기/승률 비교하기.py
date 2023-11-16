result = []
T = int(input())
for _ in range(T):
    result.append(tuple(map(int, input().split())))

for test_case in range(1, T + 1):
    A, B, C, D = result[test_case - 1]

    if A/B > C/D:
        print(f'#{test_case} ALICE')
    elif A/B < C/D:
        print(f'#{test_case} BOB')
    else:
        print(f'#{test_case} DRAW')