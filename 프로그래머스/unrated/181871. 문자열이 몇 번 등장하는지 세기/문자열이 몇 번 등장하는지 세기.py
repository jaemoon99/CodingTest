def solution(myString, pat):
    answer = 0
    for x in range(len(myString)):
        if myString[x:x+len(pat)] == pat:
            answer += 1
    return answer