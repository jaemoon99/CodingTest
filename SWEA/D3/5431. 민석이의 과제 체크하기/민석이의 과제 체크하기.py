T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    s_list = list(map(int, input().split()))
    f_list = []
    
    for x in range(1, N + 1):
        if x not in s_list:
            f_list.append(x)
    
    print(f'#{test_case}{"".join([" " + str(x) for x in f_list])}')
    