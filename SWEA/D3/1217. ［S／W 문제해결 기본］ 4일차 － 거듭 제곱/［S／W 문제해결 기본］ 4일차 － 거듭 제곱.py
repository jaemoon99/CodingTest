for test_case in range(10):
    T = int(input())
    N, M = map(int, input().split())
    
    def recursive(N, M):
        if M == 0 :
            return 1
        else:
            return N * recursive(N, M-1)

    print(f'#{T} {recursive(N, M)}')
