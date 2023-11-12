for x in range(1, 11):
    num = int(input())
    s_list = [list(input()) for _ in range(8)]
    
    for y in range(8):
        column_list = []
        for z in range(8):
            column_list.append(s_list[z][y])
        s_list.append(column_list)
            
    count = 0
    sub_list = []
    for i in range(len(s_list)):
        for j in range(8 - num + 1):
            sub_list.append(s_list[i][j:j + num])

    for k in sub_list:
        if k == k[::-1]:
            count += 1
    print(f'#{x} {count}')