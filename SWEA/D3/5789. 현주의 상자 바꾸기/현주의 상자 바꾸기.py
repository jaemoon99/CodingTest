T = int(input())
for test_case in range(1, T + 1):
    N, Q = map(int, input().split())
    box = [0] * N
    
    for x in range(Q):
        L, R = map(int, input().split())
        for y in range(L-1, R):
            box[y] = x + 1
    
    print(f'#{test_case}{"".join(" " + str(x) for x in box)}')