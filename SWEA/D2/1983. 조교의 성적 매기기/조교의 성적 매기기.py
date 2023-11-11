score_dict  = {
    "1": "A+", "2": "A0", "3": "A-", "4": "B+", "5": "B0", "6": "B-", "7": "C+", "8": "C0", "9": "C-", "10": "D0"
}
T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    score = []
    for x in range(1, N + 1):
        for _ in range(N // 10):
            score.append(x)

    score_list = []
    
    for _ in range(N):
        m, f, h = map(int, input().split())
        score_list.append(m * 0.35 + f * 0.45 + h * 0.2)
        
    sort_score = sorted(score_list, reverse = 1)

    print(f'#{test_case} {score_dict[str(score[sort_score.index(score_list[K - 1])])]}')