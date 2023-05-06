def solution(survey, choices):
    answer = ""
    cha = ["R", "C", "J", "A", "T", "F", "M", "N"]
    point = [0] * len(cha)
    for l_index in range(0, len(survey)):
        if choices[l_index] == 1:
            for l_cha in cha:
                if l_cha == survey[l_index][0]:
                    point[cha.index(survey[l_index][0])] += 3
        elif choices[l_index] == 2:
            for l_cha in cha:
                if l_cha == survey[l_index][0]:
                    point[cha.index(survey[l_index][0])] += 2
        elif choices[l_index] == 3:
            for l_cha in cha:
                if l_cha == survey[l_index][0]:
                    point[cha.index(survey[l_index][0])] += 1
        elif choices[l_index] == 5:
            for l_cha in cha:
                if l_cha == survey[l_index][1]:
                    point[cha.index(survey[l_index][1])] += 1
        elif choices[l_index] == 6:
            for l_cha in cha:
                if l_cha == survey[l_index][1]:
                    point[cha.index(survey[l_index][1])] += 2
        elif choices[l_index] == 7:
            for l_cha in cha:
                if l_cha == survey[l_index][1]:
                    point[cha.index(survey[l_index][1])] += 3

    if point[cha.index("R")] > point[cha.index("T")]:
        answer += 'R'
    elif point[cha.index("R")] < point[cha.index("T")]:
        answer += 'T'
    elif point[cha.index("R")] == point[cha.index("T")]:
        answer += 'R'

    if point[cha.index("C")] > point[cha.index("F")]:
        answer += 'C'
    elif point[cha.index("C")] < point[cha.index("F")]:
        answer += 'F'
    elif point[cha.index("C")] == point[cha.index("F")]:
        answer += 'C'

    if point[cha.index("J")] > point[cha.index("M")]:
        answer += 'J'
    elif point[cha.index("J")] < point[cha.index("M")]:
        answer += 'M'
    elif point[cha.index("J")] == point[cha.index("M")]:
        answer += 'J'

    if point[cha.index("A")] > point[cha.index("N")]:
        answer += 'A'
    elif point[cha.index("A")] < point[cha.index("N")]:
        answer += 'N'
    elif point[cha.index("A")] == point[cha.index("N")]:
        answer += 'A'
    return answer