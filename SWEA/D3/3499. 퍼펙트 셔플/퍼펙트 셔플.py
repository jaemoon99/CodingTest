T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    deck = list(input().split())
    
    if N % 2 == 0:
    	f, b = deck[:N // 2], deck[N // 2:]
    else:
        f, b = deck[:N // 2 + 1], deck[N // 2 + 1:]
        
    answer = []
    
    for x in range(N // 2):
        answer.append(f[x])
        answer.append(b[x])
        
    if len(f) == N // 2 + 1:
        answer.append(f[-1])
    elif len(b) == N // 2 + 1:
        answer.append(b[-1])
        
    print(f'#{test_case}{"".join([" " + str(x) for x in answer])}')
