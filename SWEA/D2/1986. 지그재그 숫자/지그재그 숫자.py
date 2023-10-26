T = int(input())
for t in range(1, T + 1):
    a = int(input())
    answer = 0
    for x in range(1, a+1):
        if x % 2 == 0:
            answer -= x
        else:
            answer += x
    print(f'#{t} {answer}')