T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    answer = []
    for _ in range(N):
        answer.append(f' 1/{N}')
    print(f'#{test_case}{"".join(answer)}')