T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    answer = 0
    
    for _ in range(N):
        p, x = map(float, input().split())
        answer += p * x
        
    if len(str(answer).split(".")[1]) != 6:
        answer = str(answer) + "0" * (6 - len(str(answer).split(".")[1]))
        
    print(f'#{test_case} {answer}')
