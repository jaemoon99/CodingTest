def solution(numbers, n):
    answer = 0
    for x in range(len(numbers)):
        answer += numbers[x]
        if answer > n:
            return answer