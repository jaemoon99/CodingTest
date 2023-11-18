dic = dict()
r_dic = dict()
i, j = 1, 1
for x in range(1, 50001):
    dic[x] = (i, j)
    r_dic[(i, j)] = x
    i, j = i + 1, j - 1

    if j < 1:
        i, j = 1, i

T = int(input())
for test_case in range(1, T + 1):
    p, q = map(int, input().split())
    pi, pj = dic[p]
    qi, qj = dic[q]

    ans = r_dic[(pi + qi, pj + qj)]

    print(f'#{test_case} {ans}')