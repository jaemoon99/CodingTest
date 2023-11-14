T = int(input())
for test_case in range(1, T + 1):
    words = [list(input()) for _ in range(5)]
    max_len = max([len(y) for y in words])
    
    for x in range(len(words)):
        if max_len > len(words[x]):
            for _ in range(max_len - len(words[x])):
                words[x].append("-")
    
    answer = ''
    
    for i in range(max_len):
        for j in range(len(words)):
            answer += words[j][i]
    
    print(f'#{test_case} {answer.replace("-", "")}')
    