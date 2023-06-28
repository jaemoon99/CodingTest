def solution(n, control):
    dict_control = {
        'w' : 1,
        's' : -1,
        'd' : 10,
        'a' : -10
    }
    for x in control:
        n += dict_control[x]
    return n