T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    spot = [list(map(int, input().split())) for _ in range(N)]
    count = 0
    
    for x in range(N - 1):
        for y in range(x + 1, N):
            l1, r1 = spot[x]
            l2, r2 = spot[y]
            
            if (l1 > l2 and r1 < r2) or (l1 < l2 and r1 > r2):
                count += 1

    print(f'#{test_case} {count}')