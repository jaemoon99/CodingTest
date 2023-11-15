T = int(input())
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    cost = [int(input()) for _ in range(n)]
    weight = [int(input()) for _ in range(m)]
    orders = [int(input()) for _ in range(2 * m)]
    area = [0] * len(cost)
    wait = []
    count = 0

    while orders:
        if wait:
            for x in range(len(area)):
                if area[x] == 0:
                    area[x] = wait.pop(0)

        order = orders.pop(0)

        if order > 0:
            check = 0
            for x in range(len(area)):
                if area[x] == 0:
                    area[x] = order
                    check += 1
                    break

            if check == 0:
                wait.append(order)

        else:
            for x in range(len(area)):
                if area[x] == abs(order):
                    area[x] = 0
                    count += cost[x] * weight[abs(order) - 1]
                    break

    print(f'#{test_case} {count}')