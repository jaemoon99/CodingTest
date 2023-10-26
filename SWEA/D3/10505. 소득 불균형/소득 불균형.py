T = int(input())
for t in range(1, T + 1):
    a = int(input())
    b = input()
    b_list = list(map(int, b.split()))
    b_avg = sum(b_list)/a
    answer = 0
    for x in range(len(b_list)):
        if b_avg >= b_list[x]:
            answer += 1
    print(f'#{t} {answer}')