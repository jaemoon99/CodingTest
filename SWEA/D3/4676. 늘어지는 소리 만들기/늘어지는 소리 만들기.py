T = int(input())
for test_case in range(1, T + 1):
    word = input()
    H = int(input())
    location = list(map(int, input().split()))
    
    answer = ''
    if 0 in location:
        answer += "-" * location.count(0)
        
    for x in range(len(word)):
        answer += word[x]
        if x + 1 in location:
            answer += "-" * location.count(x + 1)
                
    print(f'#{test_case} {answer}')