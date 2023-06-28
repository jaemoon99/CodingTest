def solution(myString, pat):
    c_str = ''
    for x in myString:
        if x == 'A':
            c_str += 'B'
        else:
            c_str += 'A'
    if pat in c_str:
        return 1
    return 0