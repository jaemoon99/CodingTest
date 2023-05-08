def solution(n, lost, reserve):
    intersection = list(set(lost) & set(reserve)) # 여분이 있는 사람과 잃어버린 사람 배열의 교집합
    reserve = list(set(reserve) - set(intersection)) # 두 개 중 하나를 잃어버렸기 때문에 여분이 있는 사람 배열에서 교집합 제거
    lost = list(set(lost) - set(intersection)) # 하나를 잃어버려도 하나가 남았기 때문에 잃어버린 사람 배열에서 교집합 제거
    for x in reserve: # 여분이 있는 사람 순서대로
        if x - 1 in lost: # 앞쪽부터 빌려준다
            lost.remove(x - 1) # 빌려준 번호 제거
        elif x + 1 in lost: # 앞쪽 사람이 체육복이 있는 경우 뒤쪽을 빌려준다
            lost.remove(x + 1) # 빌려준 번호 제거
    return n - len(lost) # 전체 학생 수에서 잃어버린 사람을 제외한 나머지를 반환