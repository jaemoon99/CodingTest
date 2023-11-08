T = int(input())

for test_case in range(1, T + 1):
    num = int(input())
    whole_list = []
    answer = 1
    while len(set(whole_list)) != 10:
        split_list = list(str(num * answer))
        whole_list += split_list
        answer += 1
    print(f'#{test_case} {num * (answer - 1)}')