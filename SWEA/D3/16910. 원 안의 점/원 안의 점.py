T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    count = 0
    
    for x in range(N):
        for y in range(N):
            if N ** 2 >= x ** 2 + y ** 2:
                count += 1
    
    count = count * 4 - N * 4 + 5
    
    print(f'#{test_case} {count}')