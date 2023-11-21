def solution(s):
    answer = []
    s_dic = dict()
    
    for i in range(len(s)):
        if s_dic.get(s[i]):
            answer.append(i - s_dic[s[i]] + 1)
            s_dic[s[i]] = i + 1
        else:
            answer.append(-1)
            s_dic[s[i]] = i + 1
            
    return answer