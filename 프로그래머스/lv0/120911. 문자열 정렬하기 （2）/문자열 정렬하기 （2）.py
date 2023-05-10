def solution(my_string):
    answer = ''
    for x in sorted([x.lower() for x in my_string]):
        answer += x
    return answer