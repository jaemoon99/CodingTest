def solution(myString):
    answer = ''
    for x in myString:
        if x < 'l':
            answer += 'l'
        else:
            answer += x
    return answer