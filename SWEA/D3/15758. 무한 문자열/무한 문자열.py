def find_min_mul(num1, num2):
    same_list = []
    max_n = max(num1, num2)
    min_n = min(num1, num2)

    for x in range(1,  max_n + 1):
        for y in range(1, min_n + 1):
            if min_n * x == max_n * y:
                same_list.append(min_n * x)

    return min(same_list)


T = int(input())
for test_case in range(1, T + 1):
    S, T = input().split()
    len_s, len_t = len(S), len(T)
    min_mul = find_min_mul(len_s, len_t)
    
    if S * (min_mul // len_s) == T * (min_mul // len_t):
        print(f'#{test_case} yes')
    else:
        print(f'#{test_case} no')