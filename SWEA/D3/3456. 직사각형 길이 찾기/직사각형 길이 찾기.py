T = int(input())
for test_case in range(1, T + 1):
    abc_list = list(map(int, input().split()))

    area = sum(set(abc_list)) * 2

    print(f'#{test_case} {abs(area - sum(abc_list))}')
