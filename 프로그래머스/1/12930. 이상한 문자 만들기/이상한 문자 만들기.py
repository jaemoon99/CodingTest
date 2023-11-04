def solution(s):
    answer = ''
    for x in s.split(" "):
        for i, y in enumerate(x):
            if i == 0 or i % 2 == 0:
                answer += y.upper()
            else:
                answer += y.lower()
        answer += " "
    return answer[:-1]