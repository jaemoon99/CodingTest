def solution(numbers, direction):
    answer = []
    if direction == 'right':
        answer.append(numbers[len(numbers)-1])
        for x in range(0,len(numbers)-1):
            answer.append(numbers[x])
    elif direction == 'left':
        for x in range(1, len(numbers)):
            answer.append(numbers[x])
        answer.append(numbers[0])
    return answer