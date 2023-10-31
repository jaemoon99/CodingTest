def solution(s):
    s = s.upper()
    if len(s) == 4 or len(s) == 6:
        for x in s:
            if x.isalpha():
                return False
        return True
    return False