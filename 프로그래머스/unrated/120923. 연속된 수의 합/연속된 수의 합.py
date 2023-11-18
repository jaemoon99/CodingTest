def solution(num, total):
    for x in range(-1000, 1000):
        if sum([y for y in range(x, x + num)]) == total:
            return [z for z in range(x, x + num)]