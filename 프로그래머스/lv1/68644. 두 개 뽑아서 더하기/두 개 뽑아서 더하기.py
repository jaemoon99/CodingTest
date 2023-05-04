def solution(numbers):
    answer = []
    number = sorted(numbers)
    for x in range(0, len(numbers)):
        for y in range(0, len(numbers)):
            if x != y:
                answer.append(number[x] + number[y])
    return  sorted(list(set(answer)))