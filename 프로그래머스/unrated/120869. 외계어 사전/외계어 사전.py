def solution(spell, dic):
    for i, x in enumerate(dic):
        if ''.join(sorted(spell)) == ''.join(sorted(list(x))):
            return 1
    return 2