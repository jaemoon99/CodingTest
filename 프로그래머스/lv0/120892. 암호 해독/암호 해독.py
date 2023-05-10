def solution(cipher, code):
    return ''.join([cipher[x] for x in range(code-1, len(cipher), code)])