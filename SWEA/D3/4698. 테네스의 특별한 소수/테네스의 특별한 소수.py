N = 10 ** 6
prime = [1] * (N + 1)
prime[0], prime[1] = 0, 0
for i in range(N + 1):
    if prime[i] == 1:
        for j in range(i * 2, N + 1, i):
            prime[j] = 0

T = int(input())
for test_case in range(1, T + 1):
    D, A, B = map(int, input().split())
    answer = []
    
    for i in range(A, B + 1):
        if str(D) in str(i) and prime[i]:
            answer.append(i)

    print(f'#{test_case} {len(answer)}')
