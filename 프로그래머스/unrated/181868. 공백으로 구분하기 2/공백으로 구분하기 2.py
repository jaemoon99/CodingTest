def solution(my_string):
    answer = []
    for x in list(my_string.strip().split(' ')):
        if x != "":
            answer.append(x)
    return answer