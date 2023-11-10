T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    n_list = sorted(list(map(int, input().split())))
    answer = ''.join([' '+str(x) for x in n_list])
    print(f'#{test_case}{answer}')