def solution(numbers, hand):
    answer = ''
    keypad_dic = { # 키패드 좌표화
        1 : [0, 0], 2 : [0, 1], 3 : [0, 2],
        4 : [1, 0], 5 : [1, 1], 6 : [1, 2],
        7 : [2, 0], 8 : [2, 1], 9 : [2, 2],
        10 : [3, 0], 0 : [3, 1], 12 : [3, 2]
    }
    L_location = keypad_dic[10] # 왼손 첫  위치 ("*")
    R_location = keypad_dic[12] # 오른손 첫  위치 ("#")
    for x in numbers: # 번호 루프
        if x in [1, 4, 7]: # 번호가 1, 4, 7이면
            answer += 'L' # L 추가
            L_location = keypad_dic[x] # 왼손 위치를 번호로 바꿈
        elif x in [3, 6, 9]: # 번호가 3, 6, 9이면
            answer += 'R' # R 추가
            R_location = keypad_dic[x] # 오른손 위치를 번호로 바꿈
        else: # 번호가 2, 5, 8, 0이면
            L_distance = 0 # 번호와 왼손의 거리
            R_distance = 0 # 번호와 오른손의 거리
            for i, j, k in zip(L_location, R_location, keypad_dic[x]): # 왼손, 오른손, 번호
                L_distance += abs(i - k) # 번호와 왼손의 x, y거리 계산(제곱근과 루트는 제외)
                R_distance += abs(j - k) # 번호와 오른손의 x, y거리 계산(제곱근과 루트는 제외)
            if L_distance > R_distance: # 왼손 거리가 더 멀면
                answer += 'R' # R 추가
                R_location = keypad_dic[x] # 오른손 위치를 번호로 바꿈
            elif L_distance < R_distance: # 오른손 거리가 더 멀면
                answer += 'L' # L 추가
                L_location = keypad_dic[x] # 왼손 위치를 번호로 바꿈
            else: # 거리가 같은 경우
                if hand == 'right': # 오른손 잡이면
                    answer += 'R' # R 추가
                    R_location = keypad_dic[x] # 오른손 위치를 번호로 바꿈
                else: # 왼손 잡이면
                    answer += 'L' # L 추가
                    L_location = keypad_dic[x] # 왼손 위치를 번호로 바꿈
    return answer