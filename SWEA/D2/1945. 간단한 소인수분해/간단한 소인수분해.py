T = int(input())
for test_case in range(1, T + 1):
    answer_list = [0, 0, 0, 0, 0]
    num = int(input())
    while 1:
        if num % 11 == 0:
            answer_list[4] += 1
            num = num // 11
        elif num % 7 == 0:
            answer_list[3] += 1
            num = num // 7
        elif num % 5 == 0:
            answer_list[2] += 1
            num = num // 5
        elif num % 3 == 0:
            answer_list[1] += 1
            num = num // 3
        elif num % 2 == 0:
            answer_list[0] += 1
            num = num // 2
        else:
            print(f'#{test_case} {answer_list[0]} {answer_list[1]} {answer_list[2]} {answer_list[3]} {answer_list[4]}')
            break