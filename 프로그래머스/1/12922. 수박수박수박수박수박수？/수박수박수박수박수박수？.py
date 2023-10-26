def solution(n):
    a = '수박'
    b = '수'
    if n%2 == 0:
        return n//2 * a
    else:
        return n//2 * a+b