import re

def solution(my_string):
    numbers = re.sub(r'[^0-9]', '', my_string)
    answer = 0
    for x in numbers:
        answer += int(x)
    return answer