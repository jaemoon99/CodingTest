T = int(input())
for test_case in range(1, T + 1):
    cash = int(input())
    answer = []
    count, cash = cash // 50000,  cash  % 50000
    answer.append(count)
    count, cash = cash // 10000, cash % 10000
    answer.append(count)
    count, cash = cash // 5000, cash % 5000
    answer.append(count)
    count, cash = cash // 1000, cash % 1000
    answer.append(count)
    count, cash = cash // 500, cash % 500
    answer.append(count)
    count, cash = cash // 100, cash % 100
    answer.append(count)
    count, cash = cash // 50, cash % 50
    answer.append(count)
    count, cash = cash // 10, cash % 1000
    answer.append(count)
    print(f'#{test_case}\n{"".join([str(x) + " " for x in answer]).rstrip()}')