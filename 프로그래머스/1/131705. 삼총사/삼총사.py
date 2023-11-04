from itertools import combinations


def solution(number):
    answer = 0
    number_list = list(combinations(number, 3))
    for x in number_list:
        if sum(x) == 0:
            answer += 1
    return answer