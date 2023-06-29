def solution(str1, str2):
    answer = ''
    for x, y in zip(str1, str2):
        answer += x
        answer += y
    return answer