T = int(input())
for test_case in range(1, T + 1):
    N, D = map(int, input().split())
    area = 1 + 2 * D
    check = 0
    count = 0
    
    while N > check:
        check += area
        count += 1
        
    print(f'#{test_case} {count}')