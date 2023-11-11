T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    answer_list = []
    for _ in range(N):
        C, K = map(str, input().split())
        for _ in range(int(K)):
            answer_list.append(C)
    
    print(f'#{test_case}')
    for x in range(0, len(answer_list), 10):
        answer = ''.join(str(x) for x in answer_list[x:x+10])
        print(f'{answer}')
        