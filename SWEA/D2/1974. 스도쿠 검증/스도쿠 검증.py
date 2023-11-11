T = int(input())
for test_case in range(1, T + 1):
    puzzle_list = [list(map(int, input().split())) for i in range(9)]
    check_list = puzzle_list
    
    for x in range(9):
        column_list = []
        for y in range(9):
            column_list.append(puzzle_list[y][x])
        check_list.append(column_list)
        
    for x in range(0, 9, 3):
        for y in range(0, 9, 3):
            box_list = []
            for i in range(3):
                for j in range(3):
                    box_list.append(puzzle_list[x+i][y+j])
            puzzle_list.append(box_list)
    
    check = 0
    for x in puzzle_list:
        if len(set(x)) != 9:
            check += 1
    
    if check == 0:
        print(f'#{test_case} {1}')
    else:
        print(f'#{test_case} {0}')
            
        
                    