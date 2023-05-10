def solution(age):
    answer = ''
    for x in str(age):
        answer += chr(int(x)+97)
    return answer