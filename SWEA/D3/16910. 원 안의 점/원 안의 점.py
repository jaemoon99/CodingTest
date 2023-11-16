T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    count = 0
    
    for x in range(0 - N, N + 1):
        for y in range(0 - N, N + 1):
            if N ** 2 >= x ** 2 + y ** 2:
                count += 1
                
    print(f'#{test_case} {count}')