def solution(N, stages):
    answer = {}
    people = len(stages)
    for stage in range(1, N+1):
        # 인원이 0이 아닌 경우
        if people != 0:
            # 각 스테이지에 막힌 사람의 수
            count = stages.count(stage)
            # 각 스테이지의 인원 - 실패율을 answer 딕셔너리에 추가
            answer[stage] = count / people
            # 다음 스테이지에 사람은 현재 스테이지를 성공했기 때문에 현재 스테이지 인원을 총 스테이지 인원에서 감소
            people -= count
        else:
            # 인원이 0인 경우
            answer[stage] = 0
    return sorted(answer, key=lambda x : answer[x], reverse=True)