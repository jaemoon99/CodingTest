def solution(s):
    set_s = sorted(list(set(s)))
    s_dict = dict(zip(set_s, len(set_s) * [0]))
    
    for x in s:
        s_dict[x] += 1
    
    value_list = list(s_dict.values())
    key_list = list(s_dict.keys())

    if value_list.count(1) == 1:
        return key_list[value_list.index(1)]
    else:
        return ''.join([key_list[x] for x in range(len(value_list)) if value_list[x] == 1])