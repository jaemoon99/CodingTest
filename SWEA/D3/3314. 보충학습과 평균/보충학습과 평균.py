T = int(input())
for test_case in range(1, T + 1):
    score_list = list(map(int, input().split()))
    
    for x in range(len(score_list)):
        if 40 > score_list[x]:
            score_list[x] = 40
    
    print(f'#{test_case} {int(sum(score_list) / len(score_list))}')