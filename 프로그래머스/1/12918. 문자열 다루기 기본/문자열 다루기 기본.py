def solution(s):
    s = s.upper()
    if (len(s) == 4 or len(s) == 6) and s.isdigit():
        return True
    return False