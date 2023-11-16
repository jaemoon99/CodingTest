prime = []
for i in range(2, 1000):
    for j in range(2, i):
        if i % j == 0:
            break
    else:
        prime.append(i)
        
T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    M = len(prime)
    count = 0
    
    for i in range(M):
        if prime[i] > N:
            break
        for j in range(i, M):
            if prime[j] > N:
                break
            for k in range(j, M):
                if prime[k] > N:
                    break

                if prime[i] + prime[j] + prime[k] == N:
                    count += 1

    print(f'#{test_case} {count}')