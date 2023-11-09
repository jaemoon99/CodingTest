T = int(input())
for test_case in range(1, T + 1):
    input_data = input()
    for x in range(1, 10):
        if input_data[:x] == input_data[x:2 * x]:
            print(f'#{test_case} {len(input_data[:x])}')
            break