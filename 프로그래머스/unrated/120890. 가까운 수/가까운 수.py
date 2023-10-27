def solution(array, n):
    sub_list = [abs(x-n) for x in sorted(array)]
    return sorted(array)[sub_list.index(min(sub_list))]