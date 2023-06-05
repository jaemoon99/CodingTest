from collections import deque

def solution(people, limit):
    answer = 0

    # people 정렬 후 deque로 변경
    sorted_people = deque(sorted(people, reverse=True))

    # deque가 빌 때까지
    while sorted_people:

        # 가장 무거운 사람인 왼쪽 사람을 빼낸다
        max_kg = sorted_people.popleft()

        # 맨 마지막
        if len(sorted_people) == 0:
            answer += 1
            break

        # 가장 무거운 사람과 가장 가벼운사람의 합이 limit보다 작거나 같을 경우
        if limit >= max_kg + sorted_people[-1]:

            # 가장 작은 사람도 빼냄
            sorted_people.pop()

        # 보트 수 + 1 (if 문 밖에 있는 이유는 두 사람의 합이 limit보다 커도 가장 무거운 사람이 혼자 보트를 타기 때문)
        answer += 1
    return answer