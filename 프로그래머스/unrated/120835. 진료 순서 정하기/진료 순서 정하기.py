def solution(emergency):
    sorted_list = sorted(emergency, reverse = 1)
    answer = [sorted_list.index(x) + 1 for x in emergency]
    return answer