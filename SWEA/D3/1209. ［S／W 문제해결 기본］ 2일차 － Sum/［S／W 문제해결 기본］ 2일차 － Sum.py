for test_case in range(1, 11):
    tc_num = int(input())
    matrix = [list(map(int, input().split())) for x in range(100)]
    sum_list= []
    diagonal = []
    
    for x in range(len(matrix)):
        sum_list.append(sum(matrix[x]))
        diagonal.append(matrix[x][x])
        
        column_list = []
        for y in range(len(matrix)):
            column_list.append(matrix[y][x])
        sum_list.append(sum(column_list))
    
    sum_list.append(sum(diagonal))
    
    print(f'#{test_case} {max(sum_list)}')