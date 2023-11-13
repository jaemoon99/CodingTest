T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    t = N - M
    u = M - t
    print(f'#{test_case} {u} {t}')