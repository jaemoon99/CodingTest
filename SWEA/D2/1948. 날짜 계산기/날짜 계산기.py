month_dict = {
    '1' : 31, '2' : 28, '3' : 31, '4' : 30, '5' : 31, '6' : 30, '7' : 31, '8' : 31, '9' : 30, '10' : 31, '11' : 30, '12' : 31
}
T = int(input())
for test_case in range(1, T + 1):
    input_data = input()
    n_month, n_day, f_month, f_day = map(str, input_data.split(' '))
    answer = 1
    for x in range(int(n_month), int(f_month) + 1):
        if str(x) == n_month:
            answer += month_dict[str(x)] - int(n_day)
        elif str(x) == f_month:
            answer += int(f_day)
        else:
            answer += month_dict[str(x)]
    print(f'#{test_case} {answer}')
