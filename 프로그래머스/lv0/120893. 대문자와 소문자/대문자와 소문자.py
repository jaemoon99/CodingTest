def solution(my_string):
    answer = ''
    for x in my_string:
        if x.isupper():
            x = x.lower()
        else:
            x = x.upper()
        answer += x
    return answer