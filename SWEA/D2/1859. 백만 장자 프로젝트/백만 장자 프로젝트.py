T = int(input())
for test_case in range(1, T + 1):
    count = int(input())
    num_list = list(map(int, input().split()))[::-1]
    profit = 0
    max_num = 0
    
    for x in range(len(num_list)):
        if num_list[x] > max_num:
            max_num = num_list[x]
        else:
            profit += max_num - num_list[x]
    print(f'#{test_case} {profit}')