def solution(s):
    ascii_list = sorted([ord(x) for x in s], reverse = 1)
    return ''.join([chr(x) for x in ascii_list])