T = int(input())
for test_case in range(1, T + 1):
    r_rook = [list(input()) for _ in range(8)]
    c_rook = []

    for x in range(8):
        sub = []
        for y in range(8):
            sub.append(r_rook[y][x])
        c_rook.append(sub)

    count = 0
    for i in range(8):
        for j in range(8):
            if r_rook[i][j] == "O":
                check = r_rook[i] + c_rook[j]
                if check.count('O') == 2:
                    count += 1

    if count == 8:
        print(f'#{test_case} yes')
    else:
        print(f'#{test_case} no')