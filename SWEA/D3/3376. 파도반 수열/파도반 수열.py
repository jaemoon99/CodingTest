T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    num_list = []
    
    for x in range(N):
        if 3 > x:
            num_list.append(1)
        else:
            num_list.append(sum(num_list[x - 3:x - 1]))
    
    print(f'#{test_case} {num_list[-1]}')
            