import re
def solution(my_string):
    answer = sum([int(x) for x in re.findall(r'\d+', my_string)])
    return answer