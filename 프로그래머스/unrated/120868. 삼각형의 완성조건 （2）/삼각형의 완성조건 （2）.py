def solution(sides):
    return len([x for x in range(sorted(sides)[-1] - sorted(sides)[0], sorted(sides)[-1])] + [x for x in range(sorted(sides)[-1], sum(sides))]) - 1