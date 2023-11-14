T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    S_list = sorted([int(input()) for _ in range(N)])
    avg = int(sum(S_list) / len(S_list))

    count = 0
    for x in S_list:
        if avg > x:
            count += avg - x
            
    print(f'#{test_case} {count}')