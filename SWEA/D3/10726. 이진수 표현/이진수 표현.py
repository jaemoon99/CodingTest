T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    
    if bin(M)[2:].zfill(N)[0 - N:] == "1" * N:
        print(f'#{test_case} ON')
    else:
        print(f'#{test_case} OFF')