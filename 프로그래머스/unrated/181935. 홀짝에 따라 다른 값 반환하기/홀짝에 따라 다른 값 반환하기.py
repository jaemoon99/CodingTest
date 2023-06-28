def solution(n):
    answer = 0
    if n % 2 == 1:
        return sum([x for x in range(n + 1) if x % 2 == 1])
    else:
        return sum([x**2 for x in range(n + 1) if x % 2 == 0])