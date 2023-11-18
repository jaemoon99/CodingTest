def solution(n):
    answer = [[0] * n for _ in range(n)]
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    s = [0, 0]
    c = 0

    for _ in range(n * n):
        if s == [0, 0] and answer[s[0]][s[1]] == 0:
            answer[s[0]][s[1]] = 1
        else:
            c = c % 4
            x = dx[c]
            y = dy[c]

            if s[0] + x < 0 or s[1] + y < 0 or s[0] + x >= n or s[1] + y >= n or answer[s[0] + x][s[1] + y] != 0:
                c += 1

            c = c % 4
            x = dx[c]
            y = dy[c]

            now = answer[s[0]][s[1]]
            s[0], s[1] = s[0] + x, s[1] + y
            answer[s[0]][s[1]] = now + 1

    return answer


print(solution(4))