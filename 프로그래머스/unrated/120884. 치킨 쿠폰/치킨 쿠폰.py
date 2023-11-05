def solution(chicken):
    answer, ticket = 0, 0
    while chicken > 0:
        answer += chicken // 10
        ticket += chicken % 10
        chicken = chicken // 10

    while ticket >= 10:
        answer += ticket // 10
        ticket = (ticket - ((ticket // 10) * 10)) + ticket // 10
    return answer