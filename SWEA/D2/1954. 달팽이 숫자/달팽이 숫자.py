T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    d = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    d_index = 0
    empty_list = [list([0 for _ in range(N)]) for x in range(N)]

    x, y = 0, 0

    for i in range(1, N * N + 1):
        empty_list[x][y] = i
        dx, dy = d[d_index % 4][0], d[d_index % 4][1]

        xx = x + dx
        yy = y + dy

        if x < 0 or y < 0 or xx == N or yy == N or empty_list[xx][yy] != 0:
            d_index += 1
            dx, dy = d[d_index % 4][0], d[d_index % 4][1]

        x, y = x + dx, y + dy

    print(f'#{test_case}')
    for j in empty_list:
        print(''.join([str(k) + " " for k in j]).strip())