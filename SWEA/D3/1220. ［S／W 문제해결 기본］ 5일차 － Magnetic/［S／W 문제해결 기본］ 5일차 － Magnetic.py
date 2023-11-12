T = 10
for test_case in range(1, T + 1):
    table_size = int(input())
    table = [list(map(int, input().split())) for _ in range(table_size)]
    answer = 0
    
    for x in range(table_size):
        check = ''
        for y in range(table_size):
            if table[y][x] == 1 or table[y][x] == 2:
                check += str(table[y][x])
        answer += check.count("12")

    print(f'#{test_case} {answer}')
            
