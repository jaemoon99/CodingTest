def solution(numbers, hand):
    answer = ''
    keypad_dic = {
        1 : [0, 0], 2 : [0, 1], 3 : [0, 2],
        4 : [1, 0], 5 : [1, 1], 6 : [1, 2],
        7 : [2, 0], 8 : [2, 1], 9 : [2, 2],
        10 : [3, 0], 11 : [3, 1], 12 : [3, 2]
    }
    L_location = keypad_dic[10]
    R_location = keypad_dic[12]
    for x in numbers:
        if x == 0:
            x = 11
        if x in [1, 4, 7]:
            answer += 'L'
            L_location = keypad_dic[x]
        elif x in [3, 6, 9]:
            answer += 'R'
            R_location = keypad_dic[x]
        else:
            L_distance = 0
            R_distance = 0
            for i, j, k in zip(L_location, R_location, keypad_dic[x]):
                L_distance += abs(i - k)
                R_distance += abs(j - k)
            
            if L_distance > R_distance:
                answer += 'R'
                R_location = keypad_dic[x]
            elif L_distance < R_distance:
                answer += 'L'
                L_location = keypad_dic[x]
            else:
                if hand == 'right':
                    answer += 'R'
                    R_location = keypad_dic[x]
                else:
                    answer += 'L'
                    L_location = keypad_dic[x]
    return answer