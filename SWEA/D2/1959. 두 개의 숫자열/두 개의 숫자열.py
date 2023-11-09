T = int(input())
for test_case in range(1, T + 1):
    input_len = input()
    input_a = input()
    input_b = input()
    max_value = 0
    a = list(map(int, input_a.split()))
    b = list(map(int, input_b.split()))
    while 1:
        s_num = 0
        if len(a) == len(b):
            max_value = max(max_value, sum([a[x] * b[x] for x in range(len(a))]))
            print(f'#{test_case} {max_value}')
            break
        elif len(a) > len(b):
            for x in range(len(b)):
                s_num += a[x] * b[x]
            max_value = max(max_value, s_num)
            b = [0] + b
        else:
            for x in range(len(a)):
                s_num += a[x] * b[x]
            max_value = max(max_value, s_num)
            a = [0] + a