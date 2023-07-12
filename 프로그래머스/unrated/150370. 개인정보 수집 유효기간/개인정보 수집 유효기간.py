def solution(today, terms, privacies):
    answer = []
    # 약관 코드를 key값으로, 유효기간을 value값으로 하는 dict
    terms_dic = {t[0]: int(t[2:]) * 28 for t in terms}
    
    today = list(map(int, today.split('.')))
    
    # 오늘 날짜를 일 단위로 변환
    today = today[0] * 12 * 28 + today[1] * 28 + today[2] 
    
    # 개인정보 수집일과 약관 코드를 분리
    for idx in range(len(privacies)):
        day, code = privacies[idx].split(' ')
        
        # 개인정보 수집일을 일 단위로 변환
        day = list(map(int, day.split('.')))
        day = day[0] * 12 * 28 + day[1] * 28 + day[2]
        
        # 개인정보 수집일 + 유효기간이 오늘 날짜보다 이전이면
        if day + terms_dic[code] <= today:  
            answer.append(idx + 1)

    return answer