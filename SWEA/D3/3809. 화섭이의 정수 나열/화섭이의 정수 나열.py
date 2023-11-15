T = int(input())
for test_case in range(1, T + 1) :
    N = int(input())
    S = ''
    
    while 1 :
        S += ''.join(map(str, input().split()))
        if len(S) == N :
            break

    count = 0
    
    while 1 :
        if str(count) not in S :
            break
        count += 1

    print(f'#{test_case} {count}')