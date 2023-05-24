def solution(survey, choices):
    answer = ""
    mbti_dic = {
        'R' : 0,
        'C' : 0,
        'J' : 0,
        'A' : 0,
        'T' : 0,
        'F' : 0,
        'M' : 0,
        'N' : 0
    }

    mbti_set = (('R', 'T'), ('C', 'F'), ('J', 'M'), ('A', 'N'))

    for x in range(len(choices)):
        if choices[x] >= 5:
            mbti_dic[survey[x][1]] += choices[x] - 4
        elif choices[x] == 1:
            mbti_dic[survey[x][0]] += 3
        elif choices[x] == 3:
            mbti_dic[survey[x][0]] += 1
        elif choices[x] == 2:
            mbti_dic[survey[x][0]] += 2

    for y in mbti_set:
        if mbti_dic[y[0]] == mbti_dic[y[1]]:
            answer += sorted(y)[0]
        elif mbti_dic[y[0]] > mbti_dic[y[1]]:
            answer += y[0]
        elif mbti_dic[y[0]] < mbti_dic[y[1]]:
            answer += y[1]

    return answer