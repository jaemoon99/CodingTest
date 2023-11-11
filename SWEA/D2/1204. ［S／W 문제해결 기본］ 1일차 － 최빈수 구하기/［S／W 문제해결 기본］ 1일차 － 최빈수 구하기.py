T = int(input())
for test_case in range(1, T + 1):
    num = int(input())
    score_list = list(map(int, input().split()))
    set_list = list(set(score_list))
    max_num = 0
    count = 0
    for x in set_list:
        if score_list.count(x) > count:
            max_num = x
            count = score_list.count(x)
        elif score_list.count(x) == count:
            if x > max_num:
                max_num = x
                count = score_list.count(x)
    print(f'#{test_case} {max_num}')
            
