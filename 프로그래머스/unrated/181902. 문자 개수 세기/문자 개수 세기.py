def solution(my_string):
    answer = [0] * 52
    for x in my_string:
        if ord(x) >= 97:
            answer[ord(x) - 71] += 1
        else:
            answer[ord(x) - 65] += 1
    return answer