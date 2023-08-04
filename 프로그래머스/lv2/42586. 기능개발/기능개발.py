import math
def solution(progresses, speeds):
    
    # progresses = 100에서 각 기존 progresses를 뺀 리스트
    # middle_list = progresses를 각 speeds로 나눈 리스트
    progresses = [100 - x for x in progresses]
    middle_list = [math.ceil(progresses[x] / speeds[x]) for x in range(len(progresses))]
    answer = []
    
    # 제일 첫 값을 기준으로 지정 후 카운트 1
    standard = middle_list[0]
    count = 1
    
    # middle_list의 두 번째 값부터 마지막 값 개수만큼 순회
    for x in range(1, len(middle_list)):

        # 현재 값이 기준값보다 큰 경우 : 현재 값을 기준값으로 지정 후 이때까지 쌓인 기능을 배포하고 다시 개수를 1로 지정
        if middle_list[x] > standard:
            standard = middle_list[x]
            answer.append(count)
            count = 1
            
        # 현재 값이 기준값보다 작거나 같은 경우 : 카운트 1
        else:
            count += 1
            
    # 순회가 끝났다면 쌓여있는 기능 배포
    answer.append(count)
    return answer