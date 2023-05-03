def solution(name, yearning, photo):
    answer = []
    total_score = 0
    score_dic = dict(zip(name, yearning))
    for x in range(len(photo)):
        for y in photo[x]:
            if y in name:
                total_score += score_dic[y]
        answer.append(total_score)
        total_score = 0
    return answer