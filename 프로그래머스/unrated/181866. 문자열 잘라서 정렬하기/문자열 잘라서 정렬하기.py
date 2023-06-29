def solution(myString):
    set_string = list((myString.split("x")))
    print(set_string)
    if '' in set_string:
        set_string.remove('')
    a = ' '.join(set_string).strip().split()
    return sorted(a)