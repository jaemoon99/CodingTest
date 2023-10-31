def solution(strArr):
    len_list = [len(x) for x in strArr]
    len_set = set(len_list)
    len_dict = dict(zip(len_set, len(len_set)*[0]))
    for x in len_list:
        len_dict[x] += 1
    value_list = list(len_dict.values())
    return max(value_list)