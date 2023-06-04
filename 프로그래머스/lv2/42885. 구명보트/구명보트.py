from collections import deque

def solution(people, limit):
    answer = 0
    sorted_people = deque(sorted(people, reverse=True))
    while sorted_people:
        max_kg = sorted_people.popleft()
        if len(sorted_people) == 0:
            answer += 1
            break
        if limit >= max_kg + sorted_people[-1]:
            sorted_people.pop()
        answer += 1
    return answer