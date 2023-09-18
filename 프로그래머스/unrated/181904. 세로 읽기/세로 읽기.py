def solution(my_string, m, c):
    answer = ''
    for x in range(c-1, len(my_string), m):
        answer += my_string[x]
    return answer