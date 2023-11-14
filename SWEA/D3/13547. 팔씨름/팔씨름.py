T = int(input())
for test_case in range(1, T + 1):
    result = input()
    if 7 >= result.count("x"):
        print(f'#{test_case} YES')
    else:
        print(f'#{test_case} NO')
