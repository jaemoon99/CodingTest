T = int(input())
for test_case in range(1, T + 1):
    data = list(input())
    result = ''

    if data == data[::-1]:
        result = 'Exist'
    else:
        for i in range(len(data)):
            if data[i] == '?':
                data[i] = data[len(data) - (i + 1)]
            if data == data[::-1]:
                result = 'Exist'
            else:
                result = 'Not exist'

    print(f'#{test_case} {result}')