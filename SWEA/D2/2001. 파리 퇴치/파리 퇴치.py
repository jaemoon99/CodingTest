T = int(input())

for a in range(T):
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for i in range(N)]

    kills = []
    for i in range(N-M+1):
        for j in range(N-M+1):
            fly = 0
            for k in range(M):
                for l in range(M):
                    fly += arr[i+k][j+l]
            kills.append(fly)

    print("#"+str(a+1), max(kills))
