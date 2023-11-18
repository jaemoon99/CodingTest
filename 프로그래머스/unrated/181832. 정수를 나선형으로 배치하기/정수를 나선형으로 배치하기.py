def solution(n):
    answer = [[0] * n for _ in range(n)]
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    s = [0, 0]
    c = 0

    for i in range(1, n * n + 1):
        answer[s[0]][s[1]] = i
        c = c % len(dx)
        x, y = dx[c], dy[c]

        if s[0] + x >= n or s[1] + y >= n or answer[s[0] + x][s[1] + y] != 0:
            c += 1
            c = c % len(dx)
            x, y = dx[c], dy[c]

        s[0], s[1] = s[0] + x, s[1] + y

    return answer