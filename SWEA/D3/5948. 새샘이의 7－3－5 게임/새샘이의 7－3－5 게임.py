from itertools import combinations


T = int(input())
for test_case in range(1, T + 1):
    int_list = list(map(int, input().split()))
    sub_list = list(combinations(int_list, 3)) 
    sum_list = sorted(set([sum(x) for x in sub_list]), reverse = 1)

    print(f'#{test_case} {sum_list[4]}')