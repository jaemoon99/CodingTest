def solution(myString):
    answer = ''
    for x in myString:
        if x == 'a':
            answer += x.upper()
        elif x != 'A' and x.isupper():
            answer += x.lower()
        else:
            answer += x
    return answer