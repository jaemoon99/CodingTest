def solution(score):
    score = [sum(x) for x in score]
    sort_score = sorted(score, reverse = 1)
    return [sort_score.index(x) + 1 for x in score]