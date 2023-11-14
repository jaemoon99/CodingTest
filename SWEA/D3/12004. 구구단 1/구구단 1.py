T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    
    count = 0
    for x in range(1, 10):
        if N % x == 0 and 10 > N // x:
            count += 1
            
    if count == 0:
        print(f'#{test_case} No')
    else:
        print(f'#{test_case} Yes')