T = int(input())
for test_case in range(1, T + 1):
    N, A, B = map(int, input().split())
    max_count = min(A, B)
    
    if A + B > N:
        min_count = A + B - N
    else:
        min_count = 0
        
    print(f'#{test_case} {max_count} {min_count}')
