T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            num = i
    
    print(f'#{test_case} {num + (n // num) - 2}')