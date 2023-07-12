def hanoi(s_point, mid, a_point, answer, n):
    # 움직일 원판이 한 개인 경우
    if n == 1:
        
        # 원판 이동경로 저장
        answer.append([s_point, a_point])
        return answer

    # 재귀 호출
    # n-1개의 원판을 출발점에서 중간 지점으로 이동
    hanoi(s_point, a_point, mid, answer, n - 1)
    
    # 원판 이동경로 저장
    answer.append([s_point, a_point])
    
    # n-1개의 원판을 중간 지점에서 목적지로 이동
    hanoi(mid, s_point, a_point, answer, n - 1)

    return answer

def solution(n):
    return hanoi(1, 2, 3, [], n)