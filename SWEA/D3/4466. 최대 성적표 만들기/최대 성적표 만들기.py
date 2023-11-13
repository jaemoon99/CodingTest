T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    score = sorted(list(map(int, input().split())), reverse = 1)
    
    print(f'#{test_case} {sum(score[:K])}')
    