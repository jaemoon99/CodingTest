def solution(rank, attendance):
    answer = []
    sort_rank = sorted(rank)
    for x in sort_rank:
        if len(answer) == 3:
            break
        elif attendance[rank.index(x)] == True:
            answer.append(rank.index(x))
    return 10000 * answer[0] + 100 * answer[1] + answer[2]