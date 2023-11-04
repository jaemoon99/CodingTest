def solution(score):
    answer = []
    rank = 1
    score_dict = {}
    score = [sum(x) / 2.0 for x in score]
    sort_score = sorted(score, reverse = 1)
    for i, x in enumerate(sort_score):
        if i == 0:
            score_dict[x] = rank
            rank += 1
        elif sort_score[i] == sort_score[i - 1]:
            score_dict[x] = score_dict[sort_score[i - 1]]
            rank += 1
        else:
            score_dict[x] = rank
            rank += 1

    return [score_dict[x] for x in score]