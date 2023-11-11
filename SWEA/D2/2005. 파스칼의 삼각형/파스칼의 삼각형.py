T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    p = [[1]]
    
    for x in range(N - 1):
        next_list = [1]
        for x in range(len(p[-1]) - 1):
            next_list.append(p[-1][x - 1] + p[-1][x])
        next_list.append(1)
        p.append(next_list)
        
    print(f'#{test_case}')
    for x in p:
        print(''.join([str(y)+" " for y in x]).rstrip())