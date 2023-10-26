T = int(input())
for t in range(1, T + 1):
    aeiou = ['a', 'e', 'i', 'o', 'u']
    a = input()
    answer =''
    for x in a:
        if x not in aeiou:
            answer += x
    print(f'#{t} {answer}')